package com.example.batuguntingkertas.data.database

import androidx.room.*

@Dao
interface LawanDao {

    @Query("SELECT * FROM LawanEntity")
    fun getAllLawan(): List<LawanEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLawan(user: LawanEntity): Long

    @Update
    fun updateLawan(user: LawanEntity): Int

    @Delete
    fun deleteLawan(user: UserEntity): Int

}