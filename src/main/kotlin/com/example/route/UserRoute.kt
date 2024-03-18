package com.example.route

import com.example.dto.UserLoginDto
import com.example.dto.UserRegisterDto
import com.example.service.impl.userService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Application.userRoute() {
    routing {
        post("/register") {
            val userRegisterDto = call.receive<UserRegisterDto>()
            userService.register(userRegisterDto).fold(
                onSuccess = { call.respond(HttpStatusCode.Created) },
                onFailure = { throwable ->
                    call.respond(
                        status = HttpStatusCode.BadRequest,
                        message = throwable.message ?: "Something went wrong"
                    )
                }
            )
        }

        post("/login") {
            val userLoginDto: UserLoginDto = call.receive()
            userService.login(userLoginDto).fold(
                onSuccess = { userId -> call.respond(message = userId) },
                onFailure = { throwable ->
                    call.respond(
                        status = HttpStatusCode.Unauthorized,
                        message = throwable.message ?: "Something went wrong"
                    )
                }
            )
        }

        get("/profile/{userId}") {
            val userId = call.parameters["userId"]?.let { UUID.fromString(it) }
            if (userId == null) {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = "Invalid user id"
                )
                return@get
            }
            userService.getProfile(userId).fold(
                onSuccess = { userDto -> call.respond(userDto) },
                onFailure = { throwable ->
                    call.respond(
                        status = HttpStatusCode.NotFound,
                        message = throwable.message ?: "Something went wrong"
                    )
                }
            )
        }
    }
}
