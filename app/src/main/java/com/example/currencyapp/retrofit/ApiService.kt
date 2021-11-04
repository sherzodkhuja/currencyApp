package com.example.currencyapp.retrofit

import com.example.currencyapp.models.response.CurrencyResponse
import retrofit2.http.GET

interface ApiService {
    @GET("json")
    suspend fun getCurrencies(): CurrencyResponse
}