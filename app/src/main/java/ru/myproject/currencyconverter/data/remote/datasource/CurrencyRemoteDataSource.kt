package ru.myproject.currencyconverter.data.remote.datasource

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import ru.myproject.currencyconverter.data.remote.api.RetrofitInstance
import ru.myproject.currencyconverter.data.remote.model.CurrencyResponse

class CurrencyRemoteDataSource(private val ioDispatcher: CoroutineDispatcher) {

    suspend fun fetchCurrency(): Response<CurrencyResponse> =
        withContext(ioDispatcher) {
            RetrofitInstance.api.fetchCurrency()
        }
}


