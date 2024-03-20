package com.example.route

import com.example.service.OrderService.Companion.orderService
import com.example.util.ext.getValueFromParameters
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Application.orderRoute() {
    routing {
        post("/orders/{userId}/items") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            val foodId = call.receive<Int>()
            orderService.addFoodToOrder(userId, foodId, 1).fold(
                onSuccess = { orderId -> call.respond(HttpStatusCode.OK, orderId) },
                onFailure = { call.respond(HttpStatusCode.InternalServerError, it.message ?: "Unknown error") }
            )
        }

        post("/orders/items/{itemId}") {
            val itemId = call.getValueFromParameters("itemId", String::toInt)
            val quantity = call.receive<Int>()
            orderService.updateItemInOrder(itemId, quantity).fold(
                onSuccess = { item -> call.respond(HttpStatusCode.OK, item) },
                onFailure = { call.respond(HttpStatusCode.InternalServerError, it.message ?: "Unknown error") }
            )
        }

        get("/orders/{userId}") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            orderService.getActiveOrder(userId).fold(
                onSuccess = { getActiveOrderDto -> call.respond(getActiveOrderDto) },
                onFailure = { call.respond(HttpStatusCode.NotFound, it.message ?: "No active order found") }
            )
        }

        get("/orders/{userId}/all") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            orderService.getAllOrders(userId).fold(
                onSuccess = { orders -> call.respond(orders) },
                onFailure = { call.respond(HttpStatusCode.NotFound, it.message ?: "No orders found") }
            )
        }

        get("/orders/{userId}/all/flow") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            orderService.getAllOrderFlow(userId).fold(
                onSuccess = { flow -> call.respond(flow) },
                onFailure = { call.respond(HttpStatusCode.NotFound, it.message ?: "No orders found") }
            )
        }

        get("/orders/{userId}/order/flow") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            orderService.getActiveOrderFlow(userId).fold(
                onSuccess = { flow -> call.respond(flow) },
                onFailure = { call.respond(HttpStatusCode.NotFound, it.message ?: "No active order found") }
            )
        }

        get("/orders/{userId}/complete") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            orderService.completeCurrentOrder(userId).fold(
                onSuccess = { call.respond(HttpStatusCode.OK, true) },
                onFailure = { call.respond(HttpStatusCode.InternalServerError, it.message ?: "Unknown error") }
            )
        }

        delete("/orders/{userId}/current") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            orderService.deleteCurrentOrder(userId).fold(
                onSuccess = { call.respond(HttpStatusCode.OK, true) },
                onFailure = { call.respond(HttpStatusCode.InternalServerError, it.message ?: "Unknown error") }
            )
        }

        delete("/orders/{userId}/{orderId}") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            val orderId = call.getValueFromParameters("orderId", String::toInt)
            orderService.deleteOrder(userId, orderId).fold(
                onSuccess = { call.respond(HttpStatusCode.OK, true) },
                onFailure = { call.respond(HttpStatusCode.InternalServerError, it.message ?: "Unknown error") }
            )
        }
    }
}
