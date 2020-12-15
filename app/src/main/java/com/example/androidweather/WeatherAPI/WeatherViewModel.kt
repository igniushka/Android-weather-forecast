package com.example.androidweather.WeatherAPI

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.androidweather.WeatherAPI.pojos.WeatherResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherViewModel: ViewModel() {
    private val weatherResult = MutableLiveData<WeatherResult>()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val weatherAPI = retrofit.create(WeatherInterface::class.java)

    fun getWeather(keyWord: String): LiveData<WeatherResult> {
       var call =  weatherAPI.getWeather(keyWord)
        call.enqueue(object : Callback<WeatherResult>
            {
                override fun onResponse(call: Call<WeatherResult>, response: Response<WeatherResult>) {
                    if (response.isSuccessful) {
                        weatherResult.value = response.body();
                    }
                    else{
                        weatherResult.value = null;
                    }
                }
                override fun onFailure(call: Call<WeatherResult>, ignore: Throwable?) {
                    weatherResult.value = null;
                }
            }
        )
        return weatherResult
    }
}