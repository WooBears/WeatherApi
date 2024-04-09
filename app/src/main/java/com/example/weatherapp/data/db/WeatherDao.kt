package com.example.weatherapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.weatherapp.data.remote.dto.WeatherDto

@Dao
interface WeatherDao {

    @Insert
    fun insert(weatherDto: WeatherDto)

    @Delete
    fun delete(weatherDto: WeatherDto)

    @Update
    fun update(weatherDto: WeatherDto)
}