package com.example.service.impl

import com.example.dto.UserDto
import com.example.dto.UserLoginDto
import com.example.dto.UserRegisterDto
import com.example.dto.UserUpdateLocationDto
import com.example.service.DatabaseModule.dbQuery
import com.example.service.UserService
import com.example.table.Users
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import java.util.UUID

class UserServiceImpl : UserService {
    override suspend fun login(userLoginDto: UserLoginDto): Result<String> = dbQuery {
        val loginStatement = Users.select {
            Users.email eq userLoginDto.email and (Users.password eq userLoginDto.password)
        }
        val user = loginStatement.singleOrNull()
        if (user != null) {
            user[Users.userId].toString()
        } else {
            throw Exception("Invalid email or password")
        }
    }

    override suspend fun register(userRegisterDto: UserRegisterDto): Result<Boolean> = dbQuery {
        val registerStatement = Users.select { Users.email eq userRegisterDto.email }
        val user = registerStatement.singleOrNull()
        if (user != null) {
            throw Exception("Email already exists")
        } else {
            Users.insert {
                it[fullName] = userRegisterDto.fullName
                it[email] = userRegisterDto.email
                it[password] = userRegisterDto.password
            }
            true
        }
    }

    override suspend fun getProfileFlow(userId: Int): Result<Flow<UserDto>> = dbQuery {
        val user = Users.select { Users.id eq userId }
        if (user.empty()) {
            throw Exception("User not found")
        } else {
            val userFlow = user.map(::resultRowToUserDto).asFlow()
            userFlow
        }
    }

    override suspend fun getProfile(userId: UUID): Result<UserDto> = dbQuery {
        val user = Users.select { Users.userId eq userId }
        if (user.empty()) {
            throw Exception("User not found")
        } else {
            resultRowToUserDto(user.single())
        }
    }

    override suspend fun updateUserLocation(
        userId: Int,
        userUpdateLocationDto: UserUpdateLocationDto
    ): Result<Boolean> {
        TODO("Not yet implemented")
    }

    private fun resultRowToUserDto(row: ResultRow): UserDto = UserDto(
        id = row[Users.id],
        userId = row[Users.userId].toString(),
        fullName = row[Users.fullName],
        email = row[Users.email],
        password = row[Users.password],
        phoneNumber = row[Users.phoneNumber],
        occupation = row[Users.occupation],
        employer = row[Users.employer],
        country = row[Users.country],
        latitude = row[Users.latitude],
        longitude = row[Users.longitude]
    )
}

val userService: UserService = UserServiceImpl()
