package com.example.batuguntingkertas.database

import androidx.room.*

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

    @Query("SELECT * FROM UserEntity Where name=:name And password=:password")
    fun getUser(name : String, password: String): UserEntity

    @Query("SELECT * FROM UserEntity")
    fun getValue(): UserEntity
}