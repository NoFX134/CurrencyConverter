package ru.myproject.currencyconverter.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.myproject.currencyconverter.R
import ru.myproject.currencyconverter.data.local.model.Valute
import ru.myproject.currencyconverter.databinding.ItemCurrencyBinding
import ru.myproject.currencyconverter.domain.model.Currency

class CurrencyAdapter : ListAdapter<Valute, CurrencyAdapter.CurrencyViewHolder>(DiffCallback()) {

    inner class CurrencyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        var binding: ItemCurrencyBinding = ItemCurrencyBinding.bind(itemView)

        fun bind(valute: Valute) = with(binding) {
            tvCharcode.text = valute.CharCode
            tvNominalAndName.text = "${valute.Nominal} ${valute.Name}"
            tvValue.text = valute.Value.toString()
            //tvDifference.text = Valute.difference.toString()
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

class DiffCallback : DiffUtil.ItemCallback<Valute>() {

    override fun areItemsTheSame(oldItem: Valute, newItem: Valute): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Valute, newItem: Valute): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}
