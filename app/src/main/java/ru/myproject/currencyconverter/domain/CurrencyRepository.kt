package ru.myproject.currencyconverter.domain

import retrofit2.Response
import ru.myproject.currencyconverter.data.remote.model.CurrencyResponse

interface CurrencyRepository {
    suspend fun fetchCurrency(): Response<CurrencyResponse>
}