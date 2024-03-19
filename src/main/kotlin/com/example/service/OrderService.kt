package com.example.service

import com.example.dto.FoodDto
import com.example.dto.GetActiveOrderDto
import com.example.dto.ItemDto
import com.example.dto.OrderDto
import com.example.service.impl.OrderServiceImpl
import kotlinx.coroutines.flow.Flow
import java.util.*

interface OrderService {
    suspend fun getActiveOrder(userId: UUID): Result<GetActiveOrderDto>
    suspend fun getActiveOrderFlow(userId: UUID): Result<Flow<GetActiveOrderDto>>
    suspend fun addFoodToOrder(userId: UUID, foodDto: FoodDto, quantity: Int): Result<Int>
    suspend fun updateItemInOrder(itemId: Int, quantity: Int): Result<Boolean>
    suspend fun deleteCurrentOrder(userId: UUID): Result<Boolean>
    suspend fun deleteOrder(userId: UUID, orderId: Int): Result<Boolean>
    suspend fun completeCurrentOrder(userId: UUID): Result<Boolean>
    suspend fun cancelOrder(userId: UUID, orderId: Int): Result<Boolean>
    companion object {
        val orderService: OrderService by lazy { OrderServiceImpl() }
    }
}
