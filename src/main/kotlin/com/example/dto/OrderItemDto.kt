package com.example.dto

import com.example.util.BigDecimalSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable(with = BigDecimalSerializer::class)
data class OrderItemDto(
    val id: Int,
    val orderId: Int,
    val foodId: Int,
    val quantity: Int,
    val price: BigDecimal
)
