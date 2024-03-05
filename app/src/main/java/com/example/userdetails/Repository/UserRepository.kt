package com.example.userdetails.Repository

import com.example.userdetails.API.UserService
import com.example.userdetails.ApiUtilities.RetrofitClient
import com.example.userdetails.model.Users
import com.google.gson.GsonBuilder

class UserRepository(private val apiService: UserService) {
    val builder = GsonBuilder()
    val gson = builder.create()


    private val userService = RetrofitClient.userService


    suspend fun getUserFromApi():List<Users>{
        val response = apiService.getUsers()
        return response.users
    }

}