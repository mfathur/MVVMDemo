package com.omahti.mvvmdemo.data.source.network

import com.omahti.mvvmdemo.data.source.network.response.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getAllPosts(): Response<List<PostResponse>>

}