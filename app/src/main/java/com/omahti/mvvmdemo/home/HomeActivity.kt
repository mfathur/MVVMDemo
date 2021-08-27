package com.omahti.mvvmdemo.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.omahti.mvvmdemo.R
import com.omahti.mvvmdemo.core.ServiceLocator

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(
            this,
            ServiceLocator.provideViewModelFactory()
        )[HomeViewModel::class.java]

    }
}