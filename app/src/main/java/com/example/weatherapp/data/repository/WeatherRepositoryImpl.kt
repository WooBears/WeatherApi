package com.example.weatherapp.data.repository

import androidx.lifecycle.LiveData
import com.example.weatherapp.data.baseRepository.BaseRepository
import com.example.weatherapp.data.remote.WeatherApiService
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApiService: WeatherApiService
): BaseRepository(), WeatherRepository {
    override fun getWeather(key: String, q: String, day: Int) = doRequest {
        weatherApiService.getWeather(key,q,day)
    }
}