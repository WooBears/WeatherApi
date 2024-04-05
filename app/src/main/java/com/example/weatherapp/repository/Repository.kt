package com.example.weatherapp.repository

import com.example.weatherapp.baseRepository.BaseRepository
import com.example.weatherapp.data.WeatherApiService
import javax.inject.Inject

class Repository @Inject constructor(
    private val weatherApiService: WeatherApiService
): BaseRepository() {

    fun getWeather(key: String, q: String, day: Int) = doRequest {
        weatherApiService.getWeather(key, q, day)
    }
}