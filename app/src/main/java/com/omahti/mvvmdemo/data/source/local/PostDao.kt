package com.omahti.mvvmdemo.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPosts(posts: List<PostEntity>)

    @Query("SELECT * from post")
    suspend fun getAllPosts(): List<PostEntity>

}