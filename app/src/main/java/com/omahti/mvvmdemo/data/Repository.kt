package com.omahti.mvvmdemo.data

import com.omahti.mvvmdemo.core.DataMapper
import com.omahti.mvvmdemo.data.source.local.LocalDataSource
import com.omahti.mvvmdemo.data.source.network.RemoteDataSource
import com.omahti.mvvmdemo.data.source.network.response.PostResponse

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    suspend fun getAllPostsFromNetwork() = remoteDataSource.getAllPost()

    suspend fun getAllPostsFromDb() = localDataSource.getAllPosts()

    suspend fun insertAllPostsToDb(postResponses: List<PostResponse>) {
        localDataSource.insertAllPosts(DataMapper.mapPostResponsesToEntities(postResponses))
    }

}