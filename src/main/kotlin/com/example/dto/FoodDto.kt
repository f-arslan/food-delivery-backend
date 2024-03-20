package com.example.dto

import com.example.util.BigDecimalSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class FoodDto(
    val id: Int,
    val name: String,
    val description: String,
    @Serializable(with = BigDecimalSerializer::class) val price: BigDecimal,
    val rating: Double,
    val orderCount: Int,
    val category: FoodCategory,
    val imageUrl: String
)

enum class FoodCategory {
    Burger, Pizza, Sandwich, Dessert, Snack, Drink
}
