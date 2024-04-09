package com.example.weatherapp.data.remote.dto

import com.example.weatherapp.domain.model.Condition

data class ConditionDto(
    val text: String?,
    val icon: String?,
    val code: Int?
) {
    fun toCondition() : Condition {
        return Condition(
            text = text,
            icon = icon,
            code = code
        )
    }
}