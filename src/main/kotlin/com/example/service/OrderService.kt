package com.example.service

import com.example.dto.FoodDto
import com.example.dto.GetOrderWithItemsDto
import com.example.dto.OrderDto
import com.example.service.impl.OrderServiceImpl
import kotlinx.coroutines.flow.Flow
import java.util.*

interface OrderService {
    suspend fun getActiveOrder(userId: UUID): Result<GetOrderWithItemsDto>
    suspend fun getActiveOrderFlow(userId: UUID): Result<Flow<GetOrderWithItemsDto>>
    suspend fun addFoodToOrder(userId: UUID, foodDto: FoodDto, quantity: Int): Result<Int>
    suspend fun updateItemInOrder(itemId: Int, quantity: Int): Result<Boolean>
    suspend fun deleteCurrentOrder(userId: UUID): Result<Boolean>
    suspend fun deleteOrder(userId: UUID, orderId: Int): Result<Boolean>
    suspend fun completeCurrentOrder(userId: UUID): Result<Boolean>
    suspend fun cancelOrder(userId: UUID, orderId: Int): Result<Boolean>
    suspend fun getAllOrders(userId: UUID): Result<List<GetOrderWithItemsDto>>
    suspend fun getAllOrderFlow(userId: UUID): Result<Flow<GetOrderWithItemsDto>>
    companion object {
        val orderService: OrderService by lazy { OrderServiceImpl() }
    }
}
