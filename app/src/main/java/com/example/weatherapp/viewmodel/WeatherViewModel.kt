package com.example.weatherapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.repository.Repository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor (
    private val repository: Repository
): ViewModel() {

    fun getWeather(key: String, q: String, day: Int) = repository.getWeather(key, q, day)
}