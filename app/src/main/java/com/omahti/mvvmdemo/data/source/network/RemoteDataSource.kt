package com.omahti.mvvmdemo.data.source.network

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getAllPost() = apiService.getAllPosts()
}