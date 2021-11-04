package com.example.currencyapp.retrofit

import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) {
    suspend fun getCurrencies() = apiService.getCurrencies()
}