package com.example.service.impl

import com.example.dto.UserDto
import com.example.dto.UserLoginDto
import com.example.dto.UserRegisterDto
import com.example.dto.UserUpdateLocationDto
import com.example.service.DatabaseModule.dbQuery
import com.example.service.UserService
import com.example.table.Users
import com.example.util.ServiceException.*
import com.example.util.ext.toUserDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.jetbrains.exposed.sql.*
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
            throw InvalidUsernameOrPasswordException()
        }
    }

    override suspend fun register(userRegisterDto: UserRegisterDto): Result<Boolean> = dbQuery {
        val registerStatement = Users.select { Users.email eq userRegisterDto.email }
        val user = registerStatement.singleOrNull()
        if (user != null) {
            throw EmailAlreadyExistsException()
        } else {
            Users.insert {
                it[fullName] = userRegisterDto.fullName
                it[email] = userRegisterDto.email
                it[password] = userRegisterDto.password
            }
            true
        }
    }

    override suspend fun getProfileFlow(userId: UUID): Result<Flow<UserDto>> = dbQuery {
        val user = Users.select { Users.userId eq userId }
        if (user.empty()) {
            throw UserNotFoundException(userId)
        } else {
            val userFlow = user.map { it.toUserDto() }.asFlow()
            userFlow
        }
    }

    override suspend fun getProfile(userId: UUID): Result<UserDto> = dbQuery {
        val user = Users.select { Users.userId eq userId }
        if (user.empty()) {
            throw UserNotFoundException(userId)
        } else {
            user.single().toUserDto()
        }
    }

    override suspend fun updateUserLocation(
        userId: UUID,
        userUpdateLocationDto: UserUpdateLocationDto
    ): Result<Boolean> = dbQuery {
        val user = Users.select { Users.userId eq userId }
        if (user.empty()) {
            throw UserNotFoundException(userId)
        } else {
            Users.update({ Users.userId eq userId }) {
                it[latitude] = userUpdateLocationDto.latitude
                it[longitude] = userUpdateLocationDto.longitude
            }
            true
        }
    }
}
