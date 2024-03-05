package com.example.userdetails.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userdetails.Repository.UserRepository
import com.example.userdetails.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListViewModel (private val userRepository: UserRepository): ViewModel() {



    private val _users = MutableLiveData<List<Users>>()
    val users:LiveData<List<Users>> = _users



    fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO){
            val usersFromApi = userRepository.getUserFromApi()
            _users.postValue(usersFromApi)
        }
    }
}