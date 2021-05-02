package com.example.batuguntingkertas.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class,LawanEntity::class] , version = 1)
abstract class DbUser : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun lawanDao(): LawanDao

    companion object {
        private var INSTANCE: DbUser? = null

        fun getInstance(context: Context?): DbUser? {
            if (INSTANCE == null) {
                synchronized(DbUser::class) {
                    if (context != null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            DbUser::class.java, "User.db"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}