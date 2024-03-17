package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class FoodDto(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val orderCount: Int,
    val type: String,
    val imageUrl: String
)
