package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.databinding.ForecastItemBinding
import com.example.weatherapp.model.Hour
import com.squareup.picasso.Picasso

class HoursAdapter : RecyclerView.Adapter<HoursAdapter.HoursViewHolder>(){

    private var items = arrayListOf<Hour>()

    fun addHours(list: List<Hour>){
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HoursAdapter.HoursViewHolder {
        return HoursViewHolder(
            ForecastItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HoursAdapter.HoursViewHolder, position: Int) {
       holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class HoursViewHolder(private var binding: ForecastItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(hour: Hour){

            val time = hour.time.split(" ")[1]
            binding.tvHourOfDay.text = time
            Glide.with(binding.root).load("https:" + hour.condition.icon).into(binding.ivPicOfWeather)
            binding.tvTemperatureOfDay.text = hour.temp_c.toString()
        }
    }
}