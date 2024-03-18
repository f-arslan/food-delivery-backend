package com.example.plugin

import com.example.route.foodRoute
import com.example.route.orderRoute
import com.example.route.userRoute
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Welcome to Food Delivery Backend!")
        }
    }

    userRoute()
    foodRoute()
    orderRoute()
}
