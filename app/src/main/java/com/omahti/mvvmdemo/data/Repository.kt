package com.omahti.mvvmdemo.data

import com.omahti.mvvmdemo.data.source.local.LocalDataSource
import com.omahti.mvvmdemo.data.source.network.RemoteDataSource

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    suspend fun getAllPosts() = remoteDataSource.getAllPost()

}