package com.omahti.mvvmdemo.data.source.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private fun getRetrofit() = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiServiceInstance(): ApiService = getRetrofit().create(ApiService::class.java)

}