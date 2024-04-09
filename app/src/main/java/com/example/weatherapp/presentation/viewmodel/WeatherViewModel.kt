package com.example.weatherapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.usecases.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor (
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel() {

    fun getWeather(key: String, q: String, day: Int) = getWeatherUseCase.execute(key,q,day)
}