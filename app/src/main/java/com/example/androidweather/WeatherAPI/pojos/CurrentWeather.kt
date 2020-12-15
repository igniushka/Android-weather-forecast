package com.example.androidweather.WeatherAPI.pojos

import com.google.gson.annotations.SerializedName

class CurrentWeather {

    @SerializedName("temp_c")
    var temp_c: String? = null

    @SerializedName("temp_f")
    var temp_f: String? = null

    @SerializedName("condition")
    var condition: WeatherCondition? = null

}