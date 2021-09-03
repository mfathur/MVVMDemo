package com.omahti.mvvmdemo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omahti.mvvmdemo.data.Repository
import com.omahti.mvvmdemo.data.source.network.response.PostResponse
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _posts: MutableLiveData<List<PostResponse>> = MutableLiveData(emptyList())

    val posts: LiveData<List<PostResponse>>
        get() = _posts


    fun getAllPosts() = viewModelScope.launch {
        try {
            val response = repository.getAllPosts()
            if (response.isSuccessful) {
                _posts.postValue(response.body())
            }
        } catch (e: Exception) {

        }
    }
}