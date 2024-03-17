package com.example.plugins

import com.example.dto.UserLoginDto
import com.example.service.impl.userService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureUserRouting() {
    routing {
        post("/register") {

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
    }
}
