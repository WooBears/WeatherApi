package com.example.weatherapp.data.remote.dto

import com.example.weatherapp.domain.model.Condition
import com.example.weatherapp.domain.model.Hour

data class HourDto(
    val time: String,
    val condition: ConditionDto,
    val temp_c: Double
) {
    fun toHour(): Hour{
        return Hour(
            time = time,
            condition = condition.toCondition(),
            temp_c = temp_c
        )
    }
}