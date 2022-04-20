package com.dev23.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dev23.myapplication.repository.Repository
import com.dev23.myapplication.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
private val myRepository : Repository
):ViewModel(){

    fun getValues() = liveData(Dispatchers.IO){
        emit(Response.Loading(data = null))
        try {
            emit(Response.Success(data = myRepository.getDetails()))
        } catch (exception: Exception) {
            emit(Response.Error(throwable = exception,data = null))
        }
    }

}