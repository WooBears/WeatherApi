package com.example.weatherapp.data.remote.dto

import com.example.weatherapp.domain.model.Condition
import com.example.weatherapp.domain.model.Current

data class CurrentDto(
    val last_updated: String?,
    val temp_c: Double?,
    val is_day: Int,
    val condition: ConditionDto
) {
    fun toCurrent() : Current {
        return Current(
            last_updated = last_updated,
            temp_c = temp_c,
            is_day = is_day,
            condition = condition.toCondition()
        )
    }
}