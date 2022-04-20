package com.dev23.myapplication.repository

import com.dev23.myapplication.network.EndPoints
import javax.inject.Inject

class Repository @Inject constructor(
    private val api : EndPoints
) {

    suspend fun getDetails() = api.healthCheck()

}