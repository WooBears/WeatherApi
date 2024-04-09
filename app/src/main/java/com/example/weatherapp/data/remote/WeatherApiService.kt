package com.example.weatherapp.data.remote

import com.example.weatherapp.data.remote.dto.WeatherDto
import com.example.weatherapp.domain.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherApiService {
    @GET("forecast.json")
    suspend fun getWeather(@Query("key") key: String, @Query("q") q: String, @Query("day") day: Int) : Response<WeatherDto>
}