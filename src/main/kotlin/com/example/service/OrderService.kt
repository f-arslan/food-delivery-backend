package com.example.service

import com.example.dto.FoodDto
import com.example.dto.OrderDto
import com.example.service.impl.OrderServiceImpl
import java.util.*

interface OrderService {
    suspend fun getActiveOrder(userId: UUID): Result<OrderDto>
    suspend fun addFoodToOrder(userId: UUID, foodDto: FoodDto, quantity: Int): Result<Int>
    suspend fun updateItemInOrder(orderId: Int, quantity: Int): Result<Boolean>
    suspend fun clearCurrentOrder(userId: UUID): Result<Boolean>

    companion object {
        val orderService: OrderService by lazy { OrderServiceImpl() }
    }
}
