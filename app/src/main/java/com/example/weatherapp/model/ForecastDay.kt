package com.example.weatherapp.model



data class ForecastDay(
    val date: String,
    val hour: List<Hour>
)
