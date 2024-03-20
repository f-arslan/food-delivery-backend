package com.example.service

import com.example.dto.FoodDto
import com.example.service.impl.FoodServiceImpl

interface FoodService {
    suspend fun getFoodDetail(foodId: Int): Result<FoodDto>
    suspend fun searchFood(query: String): Result<List<FoodDto>>
    suspend fun getAllFoods(): Result<List<FoodDto>>
    suspend fun getFoodsByCategory(type: String): Result<List<FoodDto>>
    suspend fun registerFood(foodDto: FoodDto): Result<Boolean>
    companion object {
        val foodService: FoodService by lazy { FoodServiceImpl() }
    }
}
