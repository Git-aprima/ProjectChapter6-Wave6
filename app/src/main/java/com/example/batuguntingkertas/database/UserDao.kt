package com.example.batuguntingkertas.database

import androidx.room.*
import com.example.batuguntingkertas.database.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAllUser(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity): Long

    @Update
    fun updateUser(user: UserEntity): Int

    @Delete
    fun deleteUser(user: UserEntity): Int

    @Query("SELECT * FROM UserEntity Where nama=:nama And password=:password")
    fun getUser(nama : String, password: String): UserEntity
}