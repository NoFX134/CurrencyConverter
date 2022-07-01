package ru.myproject.currencyconverter.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.myproject.currencyconverter.R
import ru.myproject.currencyconverter.databinding.ItemCurrencyBinding
import ru.myproject.currencyconverter.domain.model.Currency

class CurrencyAdapter : ListAdapter<Currency, CurrencyAdapter.CurrencyViewHolder>(DiffCallback()) {

    inner class CurrencyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        var binding: ItemCurrencyBinding = ItemCurrencyBinding.bind(itemView)

        fun bind(currency: Currency) = with(binding) {
            tvCharcode.text = currency.charcode
            tvNominalAndName.text = "${currency.nominal} ${currency.name}"
            tvValue.text = currency.value.toString()
            tvDifference.text = currency.difference.toString()
            ivCountryFlag.setImageResource(R.drawable.img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        return CurrencyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        getItem(position).let { holder.bind(it) }
    }


}

class DiffCallback : DiffUtil.ItemCallback<Currency>() {

    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}
