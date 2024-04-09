package com.example.weatherapp.data.remote.dto

import com.example.weatherapp.domain.model.Location

data class LocationDto(
    val name: String?,
    val region: String?,
    val country: String?,
    val localtime: String
) {
    fun toLocation() : Location {
        return Location(
            name = name,
            region = region,
            country = country,
            localtime = localtime
        )
    }
}