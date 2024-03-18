package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int,
    val userId: String,
    val fullName: String,
    val email: String,
    val password: String,
    val phoneNumber: String? = null,
    val occupation: String? = null,
    val employer: String? = null,
    val country: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null
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
