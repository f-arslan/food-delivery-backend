package com.example.dto

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class OrderDto(
    val id: Int,
    val userId: String,
    val orderTime: Instant,
    val orderStatus: OrderStatus = OrderStatus.Pending,
    val totalPrice: Double,
    val paymentDetails: String? = null,
)

enum class OrderStatus {
    Pending, Started, Processing, Finished, Cancelled
}
