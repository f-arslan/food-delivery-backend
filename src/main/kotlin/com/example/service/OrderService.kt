package com.example.service

import com.example.dto.FoodDto
import com.example.dto.GetActiveOrderDto
import com.example.dto.ItemDto
import com.example.service.impl.OrderServiceImpl
import java.util.*

interface OrderService {
    suspend fun getActiveOrder(userId: UUID): Result<GetActiveOrderDto>
    suspend fun addFoodToOrder(userId: UUID, foodDto: FoodDto, quantity: Int): Result<Int>
    suspend fun updateItemInOrder(itemId: Int, quantity: Int): Result<ItemDto>
    suspend fun clearCurrentOrder(userId: UUID): Result<Boolean>

    companion object {
        val orderService: OrderService by lazy { OrderServiceImpl() }
    }
}
