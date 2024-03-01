package com.example.userdetails.Repository

import com.example.userdetails.ApiUtilities.RetrofitClient
import com.example.userdetails.model.Users

class UserRepository {
    private val userService = RetrofitClient.userService


    suspend fun getUserFromApi():List<Users>{
        return userService.getUsers()
    }

}