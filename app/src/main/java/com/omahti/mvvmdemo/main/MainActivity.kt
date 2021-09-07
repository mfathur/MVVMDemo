package com.omahti.mvvmdemo.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.omahti.mvvmdemo.R
import com.omahti.mvvmdemo.core.ServiceLocator

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(
            this,
            ServiceLocator.provideViewModelFactory(this)
        )[MainViewModel::class.java]
    }
}