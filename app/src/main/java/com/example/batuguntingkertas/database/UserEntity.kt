package com.example.batuguntingkertas.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class UserEntity(
    @ColumnInfo(name = "username") val username :String ,
    @ColumnInfo(name = "email") val email: String ,
    @ColumnInfo(name = "name") val name: String ,
    @ColumnInfo(name = "password") val password: String ,
    @ColumnInfo(name = "image") val image: String? ,
    @PrimaryKey(autoGenerate = true) val id: Int? = 0
): Parcelable