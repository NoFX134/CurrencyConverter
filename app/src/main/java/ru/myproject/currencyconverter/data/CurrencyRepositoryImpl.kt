package ru.myproject.currencyconverter.data

import retrofit2.Response
import ru.myproject.currencyconverter.data.remote.datasource.CurrencyRemoteDataSource
import ru.myproject.currencyconverter.data.remote.model.CurrencyResponse
import ru.myproject.currencyconverter.domain.CurrencyRepository

class CurrencyRepositoryImpl(private val currencyRemoteDataSource: CurrencyRemoteDataSource) :
    CurrencyRepository {

    override suspend fun fetchCurrency(): Response<CurrencyResponse> {
        return currencyRemoteDataSource.fetchCurrency()
    }

}