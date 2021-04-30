package com.example.batuguntingkertas.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity (
    @ColumnInfo(name = "nama") val nama :String ,
    @ColumnInfo(name = "umur") val umur: Int ,
    @ColumnInfo(name = "email") val email: String ,
    @ColumnInfo(name = "password") val password: String ,
    @ColumnInfo(name = "image") val image: String ,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)