package com.example.androidweather

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.example.androidweather.WeatherAPI.WeatherViewModel
import com.example.androidweather.WeatherAPI.pojos.WeatherResult
import com.example.androidweather.databinding.WeatherLayoutBinding
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: WeatherViewModel
    private lateinit var binding: WeatherLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.weather_layout);
        viewModel = WeatherViewModel()
        binding.fetch.setOnClickListener(this)
        binding.location.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                fetchWeather()
                true
            }
            false
        }
    }

    fun setWeatherDetails(weather: WeatherResult) {
        val f = weather.currentWeather?.temp_f
        val c = weather.currentWeather?.temp_c
        val description = weather.currentWeather?.condition?.text
        var address = ""
        address += weather.location?.name
        address += ", " + weather.location?.country
        binding.address.text = address
        binding.celcius.text = c.toString() + " celcius"
        binding.farengeit.text = f.toString() + " farenheit"
        binding.description.text = description
        try {
            var urlString = weather.currentWeather?.condition?.icon
            Picasso.get()
                .load("https:$urlString").into(binding.image)

        } catch (ignore: Exception) {
        }
    }


    fun fetchWeather() {
        val location = binding.location.text.toString()
        viewModel.getWeather(location).observe(this, { weather ->
            if (weather != null) {
                setWeatherDetails(weather)
            } else {
                Toast.makeText(this, "An error occurred while fetching weather", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.fetch) {
                fetchWeather()
            }
        }
    }
}

