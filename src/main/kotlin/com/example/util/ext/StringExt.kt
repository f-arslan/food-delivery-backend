package com.example.util.ext

import com.example.dto.FoodCategory


private const val MinPassPattern = 8
private const val PassPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}$"
private const val EmailPattern = "^[A-Za-z0-9+_.-]+@(.+)\$"

fun String.isValidEmail(): Boolean = matches(EmailPattern.toRegex())
fun String.isValidPassword(): Boolean = length >= MinPassPattern && matches(PassPattern.toRegex())
fun String.toFoodType(): FoodCategory = FoodCategory.valueOf(this)
