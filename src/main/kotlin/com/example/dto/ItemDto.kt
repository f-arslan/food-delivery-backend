package com.example.dto

import com.example.util.BigDecimalSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class ItemDto(
    val id: Int,
    val orderId: Int,
    val foodId: Int,
    val quantity: Int,
    @Serializable(with = BigDecimalSerializer::class) val price: BigDecimal
)
