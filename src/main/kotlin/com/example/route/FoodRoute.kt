package com.example.route

import com.example.fake.foodDtos
import com.example.service.FoodService.Companion.foodService
import com.example.util.Constants.GENERIC_ERROR
import com.example.util.Constants.INVALID_FOOD_ID
import com.example.util.Constants.INVALID_SEARCH_QUERY
import com.example.util.ext.getValueFromParameters
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.foodRoute() {
    routing {
        get("/foods/{foodId}") {
            val foodId = call.getValueFromParameters("foodId", String::toInt)
            foodService.getFoodDetail(foodId).fold(
                onSuccess = { foodDto -> call.respond(foodDto) },
                onFailure = { throwable ->
                    call.respond(
                        status = HttpStatusCode.NotFound,
                        message = throwable.message ?: GENERIC_ERROR
                    )
                }
            )
        }

        get("/foods") {
            val searchQuery = call.request.queryParameters["search"]?.lowercase()
            if (searchQuery.isNullOrBlank()) {
                foodService.getAllFoods().fold(
                    onSuccess = { foods -> call.respond(foods) },
                    onFailure = { throwable ->
                        call.respond(
                            status = HttpStatusCode.NotFound,
                            message = throwable.message ?: GENERIC_ERROR
                        )
                    }
                )
            } else {
                foodService.searchFood(searchQuery).fold(
                    onSuccess = { foods -> call.respond(foods) },
                    onFailure = { throwable ->
                        call.respond(
                            status = HttpStatusCode.NotFound,
                            message = throwable.message ?: INVALID_SEARCH_QUERY
                        )
                    }
                )
            }
        }

        get("/foods/categories") {
            val type = call.request.queryParameters["type"]?.lowercase()?.replaceFirstChar { it.uppercase() } ?: "all"
            foodService.getFoodsByCategory(type).fold(
                onSuccess = { foods -> call.respond(foods) },
                onFailure = { throwable ->
                    call.respond(
                        status = HttpStatusCode.NotFound,
                        message = throwable.message ?: GENERIC_ERROR
                    )
                }
            )
        }

        get("/fake/foods") {
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
                foodDtos.filter { it.category == type }.shuffled().take(limit)
            }
            call.respond(foods)
        }

        get("fake/foods/stock") {
            val stock = foodDtos.groupBy { it.category }.mapValues { it.value.size }
            call.respond(stock)
        }
    }
}
