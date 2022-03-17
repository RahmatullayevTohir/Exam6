package com.example.exam6.networking

import com.example.exam6.model.Card
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {

    @Headers(
        "Content-type:application/json"
    )

    @GET("cards")
    fun getCards(): Call<List<Card>>
}