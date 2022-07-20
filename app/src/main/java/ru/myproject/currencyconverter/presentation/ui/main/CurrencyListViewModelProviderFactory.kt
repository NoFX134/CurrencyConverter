package ru.myproject.currencyconverter.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.myproject.currencyconverter.domain.CurrencyRepository

class CurrencyListViewModelProviderFactory(private val currencyRepository: CurrencyRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CurrencyListViewModel(currencyRepository) as T
    }
}

