package com.example.weatherapp.model

data class Hour(
    val time: String,
    val condition: Condition,
    val temp_c: Double
)
