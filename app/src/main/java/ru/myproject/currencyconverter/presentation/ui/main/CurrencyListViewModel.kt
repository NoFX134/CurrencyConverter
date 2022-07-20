package ru.myproject.currencyconverter.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.myproject.currencyconverter.data.local.model.CurrencyResponse
import ru.myproject.currencyconverter.util.Resource
import retrofit2.Response
import ru.myproject.currencyconverter.data.CurrencyRepositoryImpl
import ru.myproject.currencyconverter.data.local.CurrencyRemoteDataSource
import ru.myproject.currencyconverter.domain.CurrencyRepository

class CurrencyListViewModel(private val currencyRepository: CurrencyRepository) : ViewModel() {



    private val _currency: MutableLiveData<Resource<CurrencyResponse>> = MutableLiveData()
    val currency: LiveData<Resource<CurrencyResponse>> = _currency
    init {
        fetchCurrency()
    }
    fun fetchCurrency() = viewModelScope.launch {
        _currency.postValue(Resource.Loading())
        val response = currencyRepository.fetchCurrency()
        _currency.postValue(handleCurrencyResponse(response))
    }

    private fun handleCurrencyResponse(response: Response<CurrencyResponse>): Resource<CurrencyResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}