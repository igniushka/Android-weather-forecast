package com.example.androidweather.WeatherAPI.pojos

import com.google.gson.annotations.SerializedName

class WeatherCondition {
    @SerializedName("text")
    var text: String? = null;

    @SerializedName("icon")
    var icon: String? = null;
}