package com.example.dto

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class OrderDto(
    val id: Int,
    val userId: Int,
    val foodId: Int,
    val quantity: Int,
    val orderTime: Instant = Instant.DISTANT_PAST
)
