package com.example.userdetails.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.userdetails.API.UserService
import com.example.userdetails.model.UserDao
import com.example.userdetails.model.Users

class UserRepositoryImpl(
    private val userService: UserService,
    private val userDao: UserDao,
    private val userRepository: UserRepository
): ViewModel() {

    suspend fun getUsers():List<Users>{
        val usersFromApi = userService.getUsers()

        userDao.insertAll(usersFromApi)

        return usersFromApi
    }

     fun getUser(): LiveData<List<Users>> {
        return userDao.getUsersAll()
    }

    fun deleteUser(users: Users){
        userDao.delete(users)
    }

    fun updateUser(users:Users){
        userDao.update(users)
    }
}