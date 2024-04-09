package com.example.weatherapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Weather(
    val location: Location?,
    var current: Current?,
    var forecast: Forecast
)