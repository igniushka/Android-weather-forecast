package com.example.androidweather.WeatherAPI

import com.example.androidweather.WeatherAPI.pojos.WeatherResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "7819a00ceb8d4368b60175103201312"

interface WeatherInterface {
    @GET("/v1/current.json?key=$API_KEY")
    fun getWeather(
        @Query("q") keyword: String
    ): Call<WeatherResult>
}


