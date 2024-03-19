package com.example.route

import com.example.dto.UserLoginDto
import com.example.dto.UserRegisterDto
import com.example.dto.UserUpdateLocationDto
import com.example.service.UserService.Companion.userService
import com.example.util.Constants.GENERIC_ERROR
import com.example.util.Constants.INVALID_USER_ID
import com.example.util.ext.getValueFromParameters
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Application.userRoute() {
    routing {
        post("/register") {
            val userRegisterDto = call.receive<UserRegisterDto>()
            userService.register(userRegisterDto).fold(
                onSuccess = { call.respond(HttpStatusCode.Created) },
                onFailure = { throwable ->
                    call.respond(
                        status = HttpStatusCode.BadRequest,
                        message = throwable.message ?: GENERIC_ERROR
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
                        message = throwable.message ?: GENERIC_ERROR
                    )
                }
            )
        }

        get("/profile/{userId}") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            userService.getProfile(userId).fold(
                onSuccess = { userDto -> call.respond(userDto) },
                onFailure = { throwable ->
                    call.respond(
                        status = HttpStatusCode.NotFound,
                        message = throwable.message ?: GENERIC_ERROR
                    )
                }
            )
        }

        get("/profile/{userId}/flow") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            userService.getProfileFlow(userId).fold(
                onSuccess = { userDtoFlow -> call.respond(userDtoFlow) },
                onFailure = { throwable ->
                    call.respond(
                        status = HttpStatusCode.NotFound,
                        message = throwable.message ?: GENERIC_ERROR
                    )
                }
            )
        }

        post("/profile/{userId}/location") {
            val userId = call.getValueFromParameters("userId", UUID::fromString)
            val userUpdateLocationDto = call.receive<UserUpdateLocationDto>()
            userService.updateUserLocation(userId, userUpdateLocationDto).fold(
                onSuccess = { call.respond(HttpStatusCode.OK) },
                onFailure = { throwable ->
                    call.respond(
                        status = HttpStatusCode.NotFound,
                        message = throwable.message ?: GENERIC_ERROR
                    )
                }
            )
        }
    }
}
