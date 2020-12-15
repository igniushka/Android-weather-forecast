package com.example.androidweather.WeatherAPI.pojos

import com.google.gson.annotations.SerializedName

class WeatherLocation {
    @SerializedName("name")
    var name :String? = null
    @SerializedName("country")
    var country :String? = null;
}