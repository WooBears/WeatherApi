package com.example.weatherapp.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapp.domain.model.Current
import com.example.weatherapp.domain.model.Forecast
import com.example.weatherapp.domain.model.Location
import com.example.weatherapp.domain.model.Weather

@Entity
data class WeatherDto(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val location: LocationDto?,
    var current: CurrentDto?,
    var forecast: ForecastDto
) {
    fun toWeather() : Weather {
        return Weather(
            location = location?.toLocation(),
            current = current?.toCurrent(),
            forecast = forecast.toForecast()
        )
    }
}