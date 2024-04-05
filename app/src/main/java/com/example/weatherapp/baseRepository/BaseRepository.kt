package com.example.weatherapp.baseRepository

import android.annotation.SuppressLint
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

abstract class BaseRepository  {

    @SuppressLint("SuspiciousIndentation")
    protected fun <T> doRequest(
        request: suspend () -> Response<T>
    ) = liveData(Dispatchers.IO) {
        try {
            val response = request()
                emit(response.body())
        }catch (e: Exception){
            emit(e.message)
        }
    }
}