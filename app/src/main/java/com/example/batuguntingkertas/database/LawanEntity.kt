package com.example.batuguntingkertas.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LawanEntity(
    @ColumnInfo(name = "namaLawan") val namaLawan: String,
    @ColumnInfo(name = "emailLawan") val emailLawan: String,
    @PrimaryKey(autoGenerate = true) val idLawan: Int = 0
)