package com.example.batuguntingkertas.database

import androidx.room.*

@Dao
interface LawanDao {

    @Query("SELECT * FROM LawanEntity")
    fun getAllLawan(): List<LawanEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLawan(lawan : LawanEntity): Long

    @Update
    fun updateLawan(lawan :LawanEntity): Int

    @Delete
    fun deleteLawan(lawan : LawanEntity): Int

}