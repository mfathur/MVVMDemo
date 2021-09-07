package com.omahti.mvvmdemo.data.source.local

class LocalDataSource(private val postDao: PostDao,private val newsDao: NewsDao) {

    suspend fun insertAllPosts(posts: List<PostEntity>) = postDao.insertAllPosts(posts)

    suspend fun getAllPosts() = postDao.getAllPosts()

}
