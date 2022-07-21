package ru.myproject.currencyconverter.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import ru.myproject.currencyconverter.data.local.datasource.CurrencyLocalDataSource
import ru.myproject.currencyconverter.data.local.model.CurrencyDto
import ru.myproject.currencyconverter.data.remote.datasource.CurrencyRemoteDataSource
import ru.myproject.currencyconverter.data.remote.model.CurrencyResponse
import ru.myproject.currencyconverter.domain.CurrencyRepository
import ru.myproject.currencyconverter.domain.model.Currency
import ru.myproject.currencyconverter.mapper.Mapper.currencyDtoToCurrency
import ru.myproject.currencyconverter.util.Resource

class CurrencyRepositoryImpl(
    private val currencyRemoteDataSource: CurrencyRemoteDataSource,
    private val currencyLocalDataSource: CurrencyLocalDataSource
) : CurrencyRepository {

    suspend fun insertAll(){

    }

    suspend fun fetchCurrencyApi(): Resource<CurrencyResponse> {
        val response = currencyRemoteDataSource.fetchCurrency()
        return handleCurrencyResponse(response)
    }

    private fun handleCurrencyResponse(response: Response<CurrencyResponse>): Resource<CurrencyResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}


}