package com.example.service.impl

import com.example.dto.FoodDto
import com.example.dto.OrderDto
import com.example.dto.OrderStatus
import com.example.service.DatabaseModule.dbQuery
import com.example.service.OrderService
import com.example.table.Foods
import com.example.table.Items
import com.example.table.Orders
import com.example.util.ext.toOrderDto
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import java.util.*

class OrderServiceImpl : OrderService {
    override suspend fun getActiveOrder(userId: UUID): Result<OrderDto> = dbQuery {
        val card = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }
        if (card.empty()) {
            throw Exception("No active order found")
        }
        card.single().toOrderDto()
    }

    override suspend fun addFoodToOrder(userId: UUID, foodDto: FoodDto, quantity: Int): Result<Int> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.forUpdate()

        if (order.empty()) {
            createOrder(userId)
        }

        val activeOrder = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.forUpdate().single()

        val orderId = Items.insert {
            it[Items.orderId] = activeOrder[Orders.id]
            it[Items.foodId] = foodDto.id
            it[Items.quantity] = quantity
            it[Items.price] = foodDto.price.toBigDecimal()
        }[Items.id]

        val totalPrice = activeOrder[Orders.totalPrice] + (foodDto.price * quantity).toBigDecimal()
        Orders.update({ Orders.id eq activeOrder[Orders.id] }) {
            it[Orders.totalPrice] = totalPrice
        }

        orderId
    }

    override suspend fun updateItemInOrder(orderId: Int, quantity: Int): Result<Boolean> = dbQuery {
        val orderItem = Items.select { Items.id eq orderId }.singleOrNull()
        if (orderItem == null) {
            throw Exception("Order item not found")
        }

        val food = Foods.select { Foods.id eq orderItem[Items.foodId] }.single()
        val totalPrice = (food[Foods.price] * quantity).toBigDecimal()
        Items.update({ Items.id eq orderId }) {
            it[Items.quantity] = quantity
            it[Items.price] = totalPrice
        }

        val activeOrder = Orders.select { Orders.id eq orderItem[Items.orderId] }.single()
        val orderItems = Items.select { Items.orderId eq activeOrder[Orders.id] }
        val newTotalPrice = orderItems.sumOf { it[Items.price].toDouble() }.toBigDecimal()
        Orders.update({ Orders.id eq activeOrder[Orders.id] }) {
            it[Orders.totalPrice] = newTotalPrice
        }

        true
    }

    override suspend fun clearCurrentOrder(userId: UUID): Result<Boolean> {
        TODO("Not yet implemented")
    }

    private fun createOrder(userId: UUID) {
        Orders.insert {
            it[Orders.userId] = userId
            it[Orders.orderStatus] = OrderStatus.Started
        }
    }
}
