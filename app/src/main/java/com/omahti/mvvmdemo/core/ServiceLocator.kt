package com.omahti.mvvmdemo.core

import android.content.Context
import com.omahti.mvvmdemo.data.Repository
import com.omahti.mvvmdemo.data.source.local.LocalDataSource
import com.omahti.mvvmdemo.data.source.local.LocalDatabase
import com.omahti.mvvmdemo.data.source.network.ApiConfig
import com.omahti.mvvmdemo.data.source.network.RemoteDataSource

object ServiceLocator {

    private fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSource(ApiConfig.getApiServiceInstance())
    }

    private fun provideRoomDatabase(context: Context): LocalDatabase =
        LocalDatabase.getInstance(context)

    private fun provideLocalDataSource(context: Context): LocalDataSource {
        return LocalDataSource(
            provideRoomDatabase(context).postDao(),
            provideRoomDatabase(context).newsDao()
        )
    }

    private fun provideRepository(context: Context): Repository {
        return Repository(provideRemoteDataSource(), provideLocalDataSource(context))
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        return ViewModelFactory(provideRepository(context))
    }
}