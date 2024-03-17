package com.example.service

import com.example.dto.OrderDto
import kotlinx.coroutines.flow.Flow

interface OrderService {
    suspend fun getOrder(userId: Int): Flow<List<OrderDto>>
    suspend fun createOrder(orderDto: OrderDto): Result<Boolean>
}
