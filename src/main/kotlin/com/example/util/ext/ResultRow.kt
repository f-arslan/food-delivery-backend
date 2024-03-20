package com.example.util.ext

import com.example.dto.FoodDto
import com.example.dto.ItemDto
import com.example.dto.OrderDto
import com.example.dto.UserDto
import com.example.table.Foods
import com.example.table.Items
import com.example.table.Orders
import com.example.table.Users
import kotlinx.datetime.toKotlinInstant
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toFoodDto(): FoodDto = FoodDto(
    id = this[Foods.id],
    name = this[Foods.name],
    description = this[Foods.description],
    price = this[Foods.price],
    rating = this[Foods.rating],
    orderCount = this[Foods.orderCount],
    category = this[Foods.category],
    imageUrl = this[Foods.imageUrl]
)

fun ResultRow.toOrderDto(): OrderDto = OrderDto(
    id = this[Orders.id],
    userId = this[Orders.userId].toString(),
    orderTime = this[Orders.orderTime].toKotlinInstant(),
    orderStatus = this[Orders.orderStatus],
    totalPrice = this[Orders.totalPrice],
    paymentDetails = this[Orders.paymentDetails]
)

fun ResultRow.toUserDto(): UserDto = UserDto(
    id = this[Users.id],
    userId = this[Users.userId].toString(),
    fullName = this[Users.fullName],
    email = this[Users.email],
    password = this[Users.password],
    phoneNumber = this[Users.phoneNumber],
    occupation = this[Users.occupation],
    employer = this[Users.employer],
    country = this[Users.country],
    latitude = this[Users.latitude],
    longitude = this[Users.longitude]
)

fun ResultRow.toItemDto(): ItemDto = ItemDto(
    id = this[Items.id],
    orderId = this[Items.orderId],
    foodId = this[Items.foodId],
    quantity = this[Items.quantity],
    price = this[Items.price]
)
