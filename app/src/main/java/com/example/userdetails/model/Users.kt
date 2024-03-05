package com.example.userdetails.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

data class Users(
    val id:Int,
    val firstName:String,
    val lastName:String,
    val maidenName:String,
    val email:String,
)