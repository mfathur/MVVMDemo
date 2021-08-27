package com.omahti.mvvmdemo.core

import com.omahti.mvvmdemo.data.source.local.LocalDataSource
import com.omahti.mvvmdemo.data.source.network.RemoteDataSource
import com.omahti.mvvmdemo.data.Repository

object ServiceLocator {

    private fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSource()
    }

    private fun provideLocalDataSource(): LocalDataSource {
        return LocalDataSource()
    }

    private fun provideRepository(): Repository {
        return Repository(provideRemoteDataSource(), provideLocalDataSource())
    }

    fun provideViewModelFactory(): ViewModelFactory {
        return ViewModelFactory(provideRepository())
    }
}