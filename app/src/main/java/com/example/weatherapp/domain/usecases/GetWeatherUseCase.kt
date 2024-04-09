package com.example.weatherapp.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.weatherapp.data.remote.dto.WeatherDto
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository
import retrofit2.Response
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    fun execute(key: String, q: String, day: Int) : LiveData<Weather>{
        return repository.getWeather(key,q,day)
            .map { it.toWeather() }
    }
}