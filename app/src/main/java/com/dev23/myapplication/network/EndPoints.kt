package com.dev23.myapplication.network

import com.dev23.myapplication.data.NetworkResponse
import retrofit2.http.GET

interface EndPoints {

    @GET("health-check")
    suspend fun healthCheck():NetworkResponse

}