package com.example.route

import com.example.dto.FoodCategory
import com.example.fake.foodDtos
import com.example.service.FoodService.Companion.foodService
import com.example.util.Constants.GENERIC_ERROR
import com.example.util.Constants.INVALID_SEARCH_QUERY
import com.example.util.ext.getValueFromParameters
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
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

        get("/foods/categories/list") {
            val categories = FoodCategory.entries.map(FoodCategory::name)
            call.respond(categories)
        }
    }
}
