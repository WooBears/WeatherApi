package com.example.weatherapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.weatherapp.data.remote.dto.WeatherDto
import com.example.weatherapp.domain.model.Weather
import retrofit2.Response

interface WeatherRepository {

    fun getWeather(key: String, q: String, day: Int) : LiveData<WeatherDto>
}