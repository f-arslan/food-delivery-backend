package com.example.service.impl

import com.example.dto.FoodDto
import com.example.fake.FakeRestaurants
import com.example.service.DatabaseModule.dbQuery
import com.example.service.FoodService
import com.example.table.Foods
import com.example.util.ServiceException.FoodNotFoundException
import com.example.util.ext.toFoodDto
import com.example.util.ext.toFoodType
import org.jetbrains.exposed.sql.*

class FoodServiceImpl : FoodService {
    override suspend fun getFoodDetail(foodId: Int): Result<FoodDto> = dbQuery {
        val food = Foods.select { Foods.id eq foodId }.singleOrNull()
        food?.toFoodDto() ?: throw FoodNotFoundException(foodId)
    }

    override suspend fun searchFood(query: String): Result<List<FoodDto>> = dbQuery {
        val searchStatement = Foods.select {
            (Foods.name.lowerCase() like "%$query%")
        }
        val foods = searchStatement.map { it.toFoodDto() }
        foods
    }

    override suspend fun getAllFoods(): Result<List<FoodDto>> = dbQuery {
        val allFoods = Foods.selectAll()
        val foods = allFoods.map { it.toFoodDto() }
        foods
    }

    override suspend fun getFoodsByCategory(type: String): Result<List<FoodDto>> = dbQuery {
        val foodsByCategory = Foods.select { Foods.category eq type.toFoodType() }
        val foods = foodsByCategory.map { it.toFoodDto() }
        foods
    }

    override suspend fun registerFood(foodDto: FoodDto): Result<Boolean> = dbQuery {
        Foods.insert {
            it[name] = foodDto.name
            it[description] = foodDto.description
            it[price] = foodDto.price
            it[rating] = foodDto.rating
            it[orderCount] = foodDto.orderCount
            it[category] = foodDto.category
            it[imageUrl] = foodDto.imageUrl
        }
        true
    }

    override suspend fun updateRestaurant(): Result<Boolean> = dbQuery {
        val allFoodIds = Foods.selectAll().map { it[Foods.id] }
        allFoodIds.forEach { foodId ->
            Foods.update({ Foods.id eq foodId }) {
                it[restaurant] = FakeRestaurants.random()
            }
        }
        true
    }
}
