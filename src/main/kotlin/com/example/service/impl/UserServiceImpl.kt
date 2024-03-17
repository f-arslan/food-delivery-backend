package com.example.service.impl

import com.example.dto.UserDto
import com.example.dto.UserLoginDto
import com.example.dto.UserRegisterDto
import com.example.dto.UserUpdateLocationDto
import com.example.service.DatabaseModule.dbQuery
import com.example.service.UserService
import com.example.table.Users
import kotlinx.coroutines.flow.Flow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select

class UserServiceImpl: UserService {
    override suspend fun login(userLoginDto: UserLoginDto): Result<String> = dbQuery {
        val loginStatement = Users.select {
            Users.email eq userLoginDto.email and (Users.password eq userLoginDto.password)
        }
        val user = loginStatement.singleOrNull()
        if (user != null) {
            Result.success("Login successful")
        } else {
            Result.failure(Exception("Invalid email or password"))
        }
    }

    override suspend fun register(userRegisterDto: UserRegisterDto): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override fun getProfile(userId: Int): Flow<UserDto> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUserLocation(
        userId: Int,
        userUpdateLocationDto: UserUpdateLocationDto
    ): Result<Boolean> {
        TODO("Not yet implemented")
    }
}

val userService: UserService = UserServiceImpl()
