package com.example.dto

import com.example.util.BigDecimalSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.util.UUID

@Serializable(with = BigDecimalSerializer::class)
data class OrderDto(
    val id: Int,
    val userId: UUID,
    val orderTime: Instant,
    val orderStatus: OrderStatus = OrderStatus.Pending,
    val totalPrice: BigDecimal,
    val paymentDetails: String? = null,
)

enum class OrderStatus {
    Pending, Started, Processing, Finished, Cancelled
}
