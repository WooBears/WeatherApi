package com.example.weatherapp.model

data class Weather(
    val location: Location?,
    var current: Current?,
    var forecast: Forecast
)