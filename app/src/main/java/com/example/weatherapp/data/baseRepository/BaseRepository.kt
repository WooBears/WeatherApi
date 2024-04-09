package com.example.weatherapp.data.baseRepository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.weatherapp.data.remote.dto.WeatherDto
import com.example.weatherapp.domain.model.Weather
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

abstract class BaseRepository  {

    @SuppressLint("SuspiciousIndentation")
    protected fun doRequest(
        request: suspend () -> Response<WeatherDto>
    ) : LiveData<WeatherDto> = liveData(Dispatchers.IO) {
        try {
            val response = request()
            response.body()?.let { emit(it) }
        }catch (e: Exception){
            //emit(e.message)
        }
    }
}