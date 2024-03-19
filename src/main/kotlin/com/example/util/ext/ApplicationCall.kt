package com.example.util.ext

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend fun <T> ApplicationCall.getValueFromParameters(parameterName: String, transform: (String) -> T): T =
    parameters[parameterName]?.let(transform) ?: run {
        respond(HttpStatusCode.BadRequest, "Invalid $parameterName")
        throw IllegalArgumentException("Invalid $parameterName")
    }
