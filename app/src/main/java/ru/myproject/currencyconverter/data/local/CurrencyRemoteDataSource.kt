package ru.myproject.currencyconverter.data.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import ru.myproject.currencyconverter.data.local.api.RetrofitInstance
import ru.myproject.currencyconverter.data.local.model.CurrencyResponse

class CurrencyRemoteDataSource(private val ioDispatcher: CoroutineDispatcher) {

    suspend fun fetchCurrency(): Response<CurrencyResponse> =
        withContext(ioDispatcher) {
            RetrofitInstance.api.fetchCurrency()
        }
}


