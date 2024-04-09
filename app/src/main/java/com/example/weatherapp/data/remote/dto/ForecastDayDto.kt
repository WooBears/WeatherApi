package com.example.weatherapp.data.remote.dto

import com.example.weatherapp.domain.model.ForecastDay
import com.example.weatherapp.domain.model.Hour

data class ForecastDayDto(
    val date: String,
    val hour: List<HourDto>
) {

    fun toForecastDay() : ForecastDay{
        return ForecastDay(
            date = date,
            hour = hour.map { it.toHour() }
        )
    }
}