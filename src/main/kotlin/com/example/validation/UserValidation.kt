package com.example.validation

import com.example.dto.UserLoginDto
import com.example.dto.UserRegisterDto
import com.example.util.ext.isValidEmail
import com.example.util.ext.isValidPassword
import io.ktor.server.plugins.requestvalidation.*

private fun validationError(message: String) = ValidationResult.Invalid(message)

fun RequestValidationConfig.userValidation() {
    validate<UserRegisterDto> { user ->
        with(user) {
            when {
                fullName.isBlank() -> validationError("Full name cannot be empty")
                email.isBlank() -> validationError("Email cannot be empty")
                !email.isValidEmail() -> validationError("Invalid email")
                password.isBlank() -> validationError("Password cannot be empty")
                !password.isValidPassword() -> validationError("Invalid password")
                else -> ValidationResult.Valid
            }
        }
    }

    validate<UserLoginDto> { user ->
        with(user) {
            when {
                email.isBlank() -> validationError("Email cannot be empty")
                !email.isValidEmail() -> validationError("Invalid email")
                password.isBlank() -> validationError("Password cannot be empty")
                !password.isValidPassword() -> validationError("Invalid password")
                else -> ValidationResult.Valid
            }
        }
    }
}
