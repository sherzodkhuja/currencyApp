package com.example.currencyapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.currencyapp.models.Currency
import com.example.currencyapp.retrofit.ApiHelper
import com.example.currencyapp.utils.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val apiHelper: ApiHelper) {
    private val currencies = MutableLiveData<Resource<List<Currency>>>()
    fun getCurrencies(): LiveData<Resource<List<Currency>>> {
        GlobalScope.launch {
            try {
                currencies.postValue(Resource.loading(null))
                apiHelper.getCurrencies().let {
                    var list: ArrayList<Currency> = ArrayList()
                    for (i in it.indices){
                        if (it[i].nbu_buy_price != "" && it[i].nbu_cell_price != ""){
                            when(it[i].code){
                                "AED" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/c/cb/Flag_of_the_United_Arab_Emirates.svg"))}
                                "AUD" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/1200px-Flag_of_Australia_%28converted%29.svg.png"))}
                                "CAD" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Flag_of_Canada_%281964%29.svg/1200px-Flag_of_Canada_%281964%29.svg.png"))}
                                "CHF" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Civil_Ensign_of_Switzerland_%28Pantone%29.svg/200px-Civil_Ensign_of_Switzerland_%28Pantone%29.svg.png"))}
                                "CNY" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/2560px-Flag_of_the_People%27s_Republic_of_China.svg.png"))}
                                "EGP" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/f/fe/Flag_of_Egypt.svg"))}
                                "EUR" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Flag_of_Europe.svg/250px-Flag_of_Europe.svg.png"))}
                                "GBP" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_the_United_Kingdom_%283-5%29.svg/250px-Flag_of_the_United_Kingdom_%283-5%29.svg.png"))}
                                "JPY" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_Japan_%281870%E2%80%931999%29.svg/200px-Flag_of_Japan_%281870%E2%80%931999%29.svg.png"))}
                                "KRW" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Flag_of_the_Provisional_Government_of_the_Republic_of_Korea.svg/200px-Flag_of_the_Provisional_Government_of_the_Republic_of_Korea.svg.png"))}
                                "KWD" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Flag_of_Kuwait.svg/250px-Flag_of_Kuwait.svg.png"))}
                                "KZT" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Flag_of_Kazakhstan.svg/250px-Flag_of_Kazakhstan.svg.png"))}
                                "NOK" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Norway.svg/250px-Flag_of_Norway.svg.png"))}
                                "TRY" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Flag_of_Turkey.svg/250px-Flag_of_Turkey.svg.png"))}
                                "UAH" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Flag_of_Ukraine.svg/250px-Flag_of_Ukraine.svg.png"))}
                                "RUB" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Russia.svg/250px-Flag_of_Russia.svg.png"))}
                                "USD" -> {list.add(Currency(it[i].cb_price, it[i].code, it[i].date, it[i].nbu_buy_price, it[i].nbu_cell_price, it[i].title, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Flag_of_the_United_States_%28Pantone%29.svg/250px-Flag_of_the_United_States_%28Pantone%29.svg.png"))}
                            }
                        }
                    }
                    currencies.postValue(Resource.success(list))
                }

            } catch (e: Exception) {
                currencies.postValue(Resource.error(e.message ?: "Error", null))
            }
        }
        return currencies
    }
}