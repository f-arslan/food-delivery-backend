package com.example.plugin

import com.example.validation.userValidation
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*

fun Application.configureValidation() {
    install(RequestValidation) {
        userValidation()
    }
}
