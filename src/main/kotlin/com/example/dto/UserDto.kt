package com.example.dto

import kotlinx.serialization.Serializable

enum class FoodType {
    Burger, Pizza, Sandwich, Dessert, Snack, Drink
}

@Serializable
data class UserDto(
    val id: Int,
    val fullName: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val occupation: String,
    val employer: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
)

@Serializable
data class UserRegisterDto(
    val fullName: String,
    val email: String,
    val password: String,
)

@Serializable
data class UserLoginDto(
    val email: String,
    val password: String
)

@Serializable
data class UserUpdateLocationDto(
    val latitude: Double,
    val longitude: Double
)
