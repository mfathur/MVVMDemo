package com.omahti.mvvmdemo.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.omahti.mvvmdemo.data.Repository
import com.omahti.mvvmdemo.home.HomeViewModel
import com.omahti.mvvmdemo.main.MainViewModel

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown view model class")
        }
    }
}