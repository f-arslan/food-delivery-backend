package com.example.route

import com.example.dto.FoodDto
import com.example.service.OrderService.Companion.orderService
import com.example.util.Constants.INVALID_ORDER_ITEM_ID
import com.example.util.Constants.INVALID_USER_ID
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Application.orderRoute() {
    routing {
        post("/orders/{userId}/items") {
            val userId = call.parameters["userId"].let { UUID.fromString(it) } ?: run {
                call.respond(HttpStatusCode.BadRequest, INVALID_USER_ID)
                return@post
            }
            val foodDto = call.receive<FoodDto>()
            orderService.addFoodToOrder(userId, foodDto, 1).fold(
                onSuccess = { orderId -> call.respond(HttpStatusCode.OK, orderId) },
                onFailure = { call.respond(HttpStatusCode.InternalServerError, it.message ?: "Unknown error") }
            )
        }

        post("/orders/items/{orderItemId}") {
            val itemId = call.parameters["orderItemId"]?.toIntOrNull() ?: run {
                call.respond(HttpStatusCode.BadRequest, INVALID_ORDER_ITEM_ID)
                return@post
            }
            val quantity = call.receive<Int>()
            orderService.updateItemInOrder(itemId, quantity).fold(
                onSuccess = { call.respond(HttpStatusCode.OK) },
                onFailure = { call.respond(HttpStatusCode.InternalServerError, it.message ?: "Unknown error") }
            )
        }

        get("/orders/{userId}") {
            val userId = call.parameters["userId"].let { UUID.fromString(it) } ?: run {
                call.respond(HttpStatusCode.BadRequest, INVALID_USER_ID)
                return@get
            }
            orderService.getActiveOrder(userId).fold(
                onSuccess = { orderDto -> call.respond(orderDto) },
                onFailure = { call.respond(HttpStatusCode.NotFound, it.message ?: "No active order found") }
            )
        }
    }
}
