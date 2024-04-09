package com.example.weatherapp.domain.model



data class ForecastDay(
    val date: String,
    val hour: List<Hour>
)
