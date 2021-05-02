package com.example.batuguntingkertas.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LawanEntity(
    @ColumnInfo(name = "nama") val nama: String,
    @ColumnInfo(name = "email") val email: String,
    @PrimaryKey(autoGenerate = true) val idLawan: Int = 0
)