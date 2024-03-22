package com.example.dto

import com.example.util.BigDecimalSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import java.math.BigDecimal

enum class OrderStatus {
    Pending, Started, Finished, Cancelled
}

@Serializable
data class OrderDto(
    val id: Int,
    val userId: String,
    val orderTime: Instant,
    val orderStatus: OrderStatus = OrderStatus.Pending,
    @Serializable(with = BigDecimalSerializer::class) val totalPrice: BigDecimal,
    val paymentDetails: String? = null
)

@Serializable
data class GetOrderWithItemsDto(
    val order: OrderDto,
    val items: List<ItemDto>
)
