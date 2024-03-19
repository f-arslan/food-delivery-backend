package com.example.service.impl

import com.example.dto.*
import com.example.service.DatabaseModule.dbQuery
import com.example.service.OrderService
import com.example.table.Foods
import com.example.table.Items
import com.example.table.Orders
import com.example.util.ext.toFoodDto
import com.example.util.ext.toItemDto
import com.example.util.ext.toOrderDto
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import java.util.*

class OrderServiceImpl : OrderService {
    override suspend fun getActiveOrder(userId: UUID): Result<GetActiveOrderDto> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.singleOrNull() ?: throw Exception("No active order found")

        val items = Items.select { Items.orderId eq order[Orders.id] }.map { it.toItemDto() }
        GetActiveOrderDto(order.toOrderDto(), items)
    }

    override suspend fun addFoodToOrder(userId: UUID, foodDto: FoodDto, quantity: Int): Result<Int> = dbQuery {
        Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.forUpdate().singleOrNull() ?: createOrder(userId)

        val activeOrder = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.forUpdate().single()

        val item = Items.select {
            (Items.orderId eq activeOrder[Orders.id]) and (Items.foodId eq foodDto.id)
        }.singleOrNull()

        val itemId = if (item != null) {
            val newQuantity = item[Items.quantity] + quantity
            Items.update({ Items.id eq item[Items.id] }) {
                it[Items.quantity] = newQuantity
            }
            item[Items.id]
        } else {
            Items.insert {
                it[Items.orderId] = activeOrder[Orders.id]
                it[Items.foodId] = foodDto.id
                it[Items.quantity] = quantity
                it[Items.price] = foodDto.price.toBigDecimal()
            }[Items.id]
        }

        val totalPrice = activeOrder[Orders.totalPrice] + (foodDto.price * quantity).toBigDecimal()
        Orders.update({ Orders.id eq activeOrder[Orders.id] }) {
            it[Orders.totalPrice] = totalPrice
        }

        itemId
    }

    override suspend fun updateItemInOrder(itemId: Int, quantity: Int): Result<Boolean> = dbQuery {
        val item = Items.select { Items.id eq itemId }.singleOrNull() ?: throw Exception("Item not found")
        val food = Foods.select { Foods.id eq item[Items.foodId] }.singleOrNull() ?: throw Exception("Food not found")
        val order =
            Orders.select { Orders.id eq item[Items.orderId] }.singleOrNull() ?: throw Exception("Order not found")
        val newQuantity = item[Items.quantity] + quantity

        if (newQuantity < 0) {
            Items.deleteWhere { Items.id eq itemId }

            val newPrice = order[Orders.totalPrice] - (food[Foods.price] * item[Items.quantity]).toBigDecimal()
            Orders.update({ Orders.id eq item[Items.orderId] }) {
                it[Orders.totalPrice] = newPrice
            }

            return@dbQuery true
        }

        val newPrice = food[Foods.price] * newQuantity
        Items.update({ Items.id eq itemId }) {
            it[Items.quantity] = newQuantity
        }

        Orders.update({ Orders.id eq item[Items.orderId] }) {
            it[Orders.totalPrice] = newPrice.toBigDecimal()
        }

        true
    }

    override suspend fun deleteCurrentOrder(userId: UUID): Result<Boolean> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.singleOrNull() ?: throw Exception("No active order found")

        Items.deleteWhere { Items.orderId eq order[Orders.id] }
        Orders.update({ Orders.id eq order[Orders.id] }) {
            it[orderStatus] = OrderStatus.Cancelled
        }

        true
    }

    override suspend fun deleteOrder(userId: UUID, orderId: Int): Result<Boolean> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.id eq orderId)
        }.singleOrNull() ?: throw Exception("Order not found")

        Items.deleteWhere { Items.orderId eq order[Orders.id] }
        Orders.deleteWhere { Orders.id eq order[Orders.id] }

        true
    }

    override suspend fun completeCurrentOrder(userId: UUID): Result<Boolean> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.singleOrNull() ?: throw Exception("No active order found")

        Orders.update({ Orders.id eq order[Orders.id] }) {
            it[orderStatus] = OrderStatus.Finished
        }

        true
    }

    override suspend fun cancelOrder(userId: UUID, orderId: Int): Result<Boolean> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.id eq orderId)
        }.singleOrNull() ?: throw Exception("Order not found")

        Orders.update({ Orders.id eq order[Orders.id] }) {
            it[orderStatus] = OrderStatus.Cancelled
        }

        true
    }

    private fun createOrder(userId: UUID) {
        Orders.insert {
            it[Orders.userId] = userId
            it[Orders.orderStatus] = OrderStatus.Started
        }
    }
}
