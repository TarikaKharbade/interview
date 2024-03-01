package com.example.userdetails.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Entity(tableName = "users")
data class Users(
    val id:Int,
    val firstName:String,
    val email:String,
)

@Dao
interface UserDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<Users>)

    @Update
    fun update(users: Users)

    @Delete
    fun delete(users: Users)

    @Query("SELECT * FROM users")
    fun getUsersAll():LiveData<List<Users>>
}


