package com.dev23.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.dev23.myapplication.R
import com.dev23.myapplication.utils.Response
import com.dev23.myapplication.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val myViewModel : MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardsList = findViewById<CardsList>(R.id.cardsListView)

            myViewModel.getValues().observe(this){
                when(it){
                    is Response.Success -> {
                        Log.d("sdcsdvdf","Success" +it.data)
                        cardsList.initData(it.data?.data?.health?.toMutableList()!!)
                    }
                    is Response.Error -> {
                        Log.d("sdcsdvdf","Error")
                    }
                    else -> {
                        Log.d("sdcsdvdf","Loading")
                    }
                }
            }
    }
}