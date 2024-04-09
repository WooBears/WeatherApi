package com.example.weatherapp.data.remote.dto

import com.example.weatherapp.domain.model.Forecast
import com.example.weatherapp.domain.model.ForecastDay

data class ForecastDto(
    var forecastday: List<ForecastDayDto>
) {
    fun toForecast() : Forecast {
        return Forecast(
            forecastday = forecastday.map { it.toForecastDay() }
        )
    }
}