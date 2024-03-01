package com.example.userdetails.API

import com.example.userdetails.model.Users
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers():List<Users>
}