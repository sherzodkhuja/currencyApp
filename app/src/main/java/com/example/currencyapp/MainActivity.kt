package com.example.currencyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.currencyapp.adapter.CurrencyAdapter
import com.example.currencyapp.databinding.ActivityMainBinding
import com.example.currencyapp.viewmodels.MainViewModel
import com.example.currencyapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var currencyAdapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getCurrencies().observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.date.text = "Обновлено "+it.data?.get(0)?.date?.substring(10)
                    currencyAdapter = CurrencyAdapter(it.data ?: emptyList())
                    binding.rv.adapter = currencyAdapter
                }
            }
        })
    }
}