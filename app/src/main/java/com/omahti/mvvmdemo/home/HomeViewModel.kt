package com.omahti.mvvmdemo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omahti.mvvmdemo.data.Repository
import com.omahti.mvvmdemo.data.source.local.PostEntity
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _posts: MutableLiveData<List<PostEntity>> = MutableLiveData(emptyList())

    val posts: LiveData<List<PostEntity>>
        get() = _posts


    fun getAllPosts() = viewModelScope.launch {
        try {
            val response = repository.getAllPostsFromNetwork()
            if (response.isSuccessful) {
                response.body()?.let { repository.insertAllPostsToDb(it) }
                _posts.postValue(repository.getAllPostsFromDb())
            }
        } catch (e: Exception) {

        }
    }
}