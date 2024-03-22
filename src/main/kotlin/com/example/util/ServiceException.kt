package com.example.util

import java.util.*

sealed class ServiceException(message: String) : Exception(message) {
    class ActiveOrderNotFoundException(userId: UUID) :
        ServiceException("No active order found for user ID: $userId")
    class FoodNotFoundException(foodId: Int) : ServiceException("Food not found with ID: $foodId")
    class NotFoundException(orderId: Int) : ServiceException("Order not found with ID: $orderId")
    class ItemNotFoundException(itemId: Int) : ServiceException("Item not found with ID: $itemId")
    class InvalidUsernameOrPasswordException : ServiceException("Invalid username or password")
    class EmailAlreadyExistsException : ServiceException("Email already exists")
    class UserNotFoundException(userId: UUID) : ServiceException("User not found with ID: $userId")
}
