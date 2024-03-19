package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class ItemDto(
    val id: Int,
    val orderId: Int,
    val foodId: Int,
    val quantity: Int,
    val price: Double
)
