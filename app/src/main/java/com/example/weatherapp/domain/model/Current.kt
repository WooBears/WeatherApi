package com.example.weatherapp.domain.model

data class Current(
    val last_updated: String?,
    val temp_c: Double?,
    val is_day: Int,
    val condition: Condition
)