package com.example.plugin

import com.example.fake.foodDtos
import com.example.route.userRoute
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get ("/") {
            call.respondText("Hello, to Food API!")
        }
        get("/foods") {
            val type = call.request.queryParameters["type"]?.lowercase()?.replaceFirstChar { it.uppercase() } ?: "all"
            val limit = call.request.queryParameters["limit"]?.toIntOrNull() ?: 10
            require(limit in 0..100) {
                call.respondText(
                    text = "Limit must be between 0 and 100",
                    status = HttpStatusCode.BadRequest
                )
                return@get
            }
            val foods = if (type == "all") {
                foodDtos.shuffled().take(limit)
            } else {
                foodDtos.filter { it.type == type }.shuffled().take(limit)
            }
            call.respond(foods)
        }

        get("/foods/stock") {
            val stock = foodDtos.groupBy { it.type }.mapValues { it.value.size }
            call.respond(stock)
        }
    }

    userRoute()
}
