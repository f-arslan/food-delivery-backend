package com.example.service.impl

import com.example.dto.GetOrderWithItemsDto
import com.example.dto.OrderStatus
import com.example.service.DatabaseModule.dbQuery
import com.example.service.OrderService
import com.example.table.Foods
import com.example.table.Items
import com.example.table.Orders
import com.example.util.ServiceException.*
import com.example.util.ext.toItemDto
import com.example.util.ext.toOrderDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import java.util.*

class OrderServiceImpl : OrderService {
    override suspend fun getActiveOrder(userId: UUID): Result<GetOrderWithItemsDto> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.singleOrNull() ?: throw ActiveOrderNotFoundException(userId)

        val items = Items.select { Items.orderId eq order[Orders.id] }.map { it.toItemDto() }
        GetOrderWithItemsDto(order.toOrderDto(), items)
    }

    override suspend fun getActiveOrderFlow(userId: UUID): Result<Flow<GetOrderWithItemsDto>> = dbQuery {
        Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.map { order ->
            val items = Items.select { Items.orderId eq order[Orders.id] }.map { it.toItemDto() }
            GetOrderWithItemsDto(order.toOrderDto(), items)
        }.asFlow()
    }

    override suspend fun addFoodToOrder(userId: UUID, foodId: Int, quantity: Int): Result<Int> = dbQuery {
        val food = Foods.select { Foods.id eq foodId }.singleOrNull() ?: throw FoodNotFoundException(foodId)

        Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.forUpdate().singleOrNull() ?: createOrder(userId)

        val activeOrder = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.forUpdate().single()

        val item = Items.select {
            (Items.orderId eq activeOrder[Orders.id]) and (Items.foodId eq foodId)
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
                it[Items.foodId] = foodId
                it[Items.quantity] = quantity
                it[Items.price] = food[Foods.price]
            }[Items.id]
        }

        val totalPrice = activeOrder[Orders.totalPrice] + food[Foods.price] * quantity.toBigDecimal()
        Orders.update({ Orders.id eq activeOrder[Orders.id] }) {
            it[Orders.totalPrice] = totalPrice
        }

        itemId
    }

    override suspend fun updateItemInOrder(itemId: Int, quantity: Int): Result<Boolean> = dbQuery {
        val item = Items.select { Items.id eq itemId }.singleOrNull()
            ?: throw ItemNotFoundException(itemId)
        val food = Foods.select { Foods.id eq item[Items.foodId] }.singleOrNull()
            ?: throw FoodNotFoundException(item[Items.foodId])
        val order = Orders.select { Orders.id eq item[Items.orderId] }.singleOrNull()
            ?: throw NotFoundException(item[Items.orderId])

        val newQuantity = item[Items.quantity] + quantity

        when {
            newQuantity < 0 -> {
                Items.deleteWhere { Items.id eq itemId }
                val newPrice = order[Orders.totalPrice] - (food[Foods.price] * item[Items.quantity].toBigDecimal())
                Orders.update({ Orders.id eq item[Items.orderId] }) {
                    it[Orders.totalPrice] = newPrice
                }
            }

            else -> {
                val newPrice = food[Foods.price] * newQuantity.toBigDecimal()
                Items.update({ Items.id eq itemId }) {
                    it[Items.quantity] = newQuantity
                }

                Orders.update({ Orders.id eq item[Items.orderId] }) {
                    it[Orders.totalPrice] = newPrice
                }

            }
        }
        true
    }

    override suspend fun deleteCurrentOrder(userId: UUID): Result<Boolean> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.singleOrNull() ?: throw ActiveOrderNotFoundException(userId)

        Items.deleteWhere { Items.orderId eq order[Orders.id] }
        Orders.update({ Orders.id eq order[Orders.id] }) {
            it[orderStatus] = OrderStatus.Cancelled
        }

        true
    }

    override suspend fun deleteOrder(userId: UUID, orderId: Int): Result<Boolean> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.id eq orderId)
        }.singleOrNull() ?: throw NotFoundException(orderId)

        Items.deleteWhere { Items.orderId eq order[Orders.id] }
        Orders.deleteWhere { Orders.id eq order[Orders.id] }

        true
    }

    override suspend fun completeCurrentOrder(userId: UUID): Result<Boolean> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.orderStatus eq OrderStatus.Started)
        }.singleOrNull() ?: throw ActiveOrderNotFoundException(userId)

        Orders.update({ Orders.id eq order[Orders.id] }) {
            it[orderStatus] = OrderStatus.Finished
        }

        true
    }

    override suspend fun cancelOrder(userId: UUID, orderId: Int): Result<Boolean> = dbQuery {
        val order = Orders.select {
            (Orders.userId eq userId) and (Orders.id eq orderId)
        }.singleOrNull() ?: throw NotFoundException(orderId)

        Orders.update({ Orders.id eq order[Orders.id] }) {
            it[orderStatus] = OrderStatus.Cancelled
        }

        true
    }

    override suspend fun getAllOrders(userId: UUID): Result<List<GetOrderWithItemsDto>> = dbQuery {
        val orders = Orders.select { Orders.userId eq userId }.map { order ->
            val items = Items.select { Items.orderId eq order[Orders.id] }.map { it.toItemDto() }
            GetOrderWithItemsDto(order.toOrderDto(), items)
        }
        orders
    }

    override suspend fun getAllOrderFlow(userId: UUID): Result<Flow<GetOrderWithItemsDto>> = dbQuery {
        Orders.select { Orders.userId eq userId }.map { order ->
            val items = Items.select { Items.orderId eq order[Orders.id] }.map { it.toItemDto() }
            GetOrderWithItemsDto(order.toOrderDto(), items)
        }.asFlow()
    }

    private fun createOrder(userId: UUID) {
        Orders.insert {
            it[Orders.userId] = userId
            it[Orders.orderStatus] = OrderStatus.Started
        }
    }
}
