package com.example.exam6.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClint {

    var BASE_URL = "http://dummy.restapiexample.com/api/v1/"

    fun getRetrofit():Retrofit{
        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return build
    }

    fun <T> createService(service: Class<T>):T{
        return getRetrofit().create(service)
    }
}