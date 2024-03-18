package com.example

import com.example.plugin.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        factory = Netty,
        port = System.getenv("PORT")?.toInt() ?: 8080,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureDatabase()
    configureRateLimiting()
    configureSerialization()
    configureRouting()
    configureValidation()
    configureStatusPages()
}
