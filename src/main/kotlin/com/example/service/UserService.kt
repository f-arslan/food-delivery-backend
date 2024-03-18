package com.example.service

import com.example.dto.UserDto
import com.example.dto.UserLoginDto
import com.example.dto.UserRegisterDto
import com.example.dto.UserUpdateLocationDto
import com.example.service.impl.UserServiceImpl
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface UserService {
    suspend fun login(userLoginDto: UserLoginDto): Result<String>
    suspend fun register(userRegisterDto: UserRegisterDto): Result<Boolean>
    suspend fun getProfileFlow(userId: UUID): Result<Flow<UserDto>>
    suspend fun getProfile(userId: UUID): Result<UserDto>
    suspend fun updateUserLocation(userId: UUID, userUpdateLocationDto: UserUpdateLocationDto): Result<Boolean>

    companion object {
        val userService: UserService by lazy { UserServiceImpl() }
    }
}
