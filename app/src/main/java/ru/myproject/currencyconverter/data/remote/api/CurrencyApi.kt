package ru.myproject.currencyconverter.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import ru.myproject.currencyconverter.data.remote.model.CurrencyResponse

interface CurrencyApi {

    @GET("daily_json.js")
    suspend fun fetchCurrency():Response<CurrencyResponse>
}