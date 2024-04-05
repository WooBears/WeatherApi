package com.example.weatherapp.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.adapter.HoursAdapter
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.model.Weather
import com.example.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    private val viewModel: WeatherViewModel by viewModels()
    private val hoursAdapter by lazy { HoursAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
        // Set up the custom Toolbar

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.rvRecycler.adapter = hoursAdapter
        val search = binding.searchEditText
        search.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                viewModel.getWeather("2655a7da71f74bd28c4123217240304", s.toString(), 2).observe(viewLifecycleOwner){result ->
                    if (result is Weather){
                        updateUI(result)

                        result.let {
                            it.forecast.forecastday.forEach{ forecastWeather->
                                hoursAdapter.addHours(forecastWeather.hour)
                                forecastWeather.hour.forEach{
                                    if (it.condition.text!!.contains("rain")){
                                        binding.clLayout.setBackgroundResource(R.drawable.rainy_bg)
                                    }
                                    else if(it.condition.text!!.contains("clear")){
                                        binding.clLayout.setBackgroundResource(R.drawable.sunny_bg)
                                    }
                                    else if (it.condition.text!!.contains("snowy")){
                                        binding.clLayout.setBackgroundResource(R.drawable.snow_bg)
                                    }
                                    else if (it.condition.text!!.contains("cloudy")){
                                        binding.clLayout.setBackgroundResource(R.drawable.cloudy_bg)
                                    }
                                    else {
                                        binding.clLayout.setBackgroundResource(R.drawable.sunny_bg)
                                    }
                                }

                            }
                        }
                    }
                }

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    private fun updateUI(weather: Weather){
        binding.tvDegrees.text = weather.current?.temp_c.toString()
        binding.tvCityAbbreviation.text = weather.location?.name.toString()
    }

}