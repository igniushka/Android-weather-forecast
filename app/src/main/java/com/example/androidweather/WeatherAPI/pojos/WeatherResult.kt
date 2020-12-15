package com.example.androidweather.WeatherAPI.pojos

import com.google.gson.annotations.SerializedName

class WeatherResult {
    @SerializedName("current")
    var currentWeather: CurrentWeather? = null;
    @SerializedName("location")
    var location: WeatherLocation? = null;
}