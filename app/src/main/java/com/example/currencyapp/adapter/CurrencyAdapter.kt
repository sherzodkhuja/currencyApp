package com.example.currencyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.databinding.ItemCurrencyBinding
import com.example.currencyapp.models.Currency
import com.squareup.picasso.Picasso

class CurrencyAdapter(var list: List<Currency>): RecyclerView.Adapter<CurrencyAdapter.Vh>() {
    inner class Vh(var itemCurrencyBinding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(itemCurrencyBinding.root) {

        fun onBind(currency: Currency) {
            Picasso.get().load(currency.image).into(itemCurrencyBinding.flag)
            itemCurrencyBinding.code.text = currency.code
            itemCurrencyBinding.buyPrice.text = currency.nbu_buy_price
            itemCurrencyBinding.cellPrice.text = currency.nbu_cell_price
            itemCurrencyBinding.cbPrice.text = currency.cb_price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}