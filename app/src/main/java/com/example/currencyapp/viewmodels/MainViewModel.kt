package com.example.currencyapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.currencyapp.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: CurrencyRepository) : ViewModel() {
    fun getCurrencies() = repository.getCurrencies()
}