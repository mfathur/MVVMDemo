package com.omahti.mvvmdemo.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PostEntity::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var instance: LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase = instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(
                context.applicationContext,
                LocalDatabase::class.java,
                "post_database"
            ).build().apply { instance = this }
        }
    }
}