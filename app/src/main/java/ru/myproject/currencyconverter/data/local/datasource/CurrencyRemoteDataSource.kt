package ru.myproject.currencyconverter.data.local.datasource

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Response
import ru.myproject.currencyconverter.data.local.database.CurrencyDatabase
import ru.myproject.currencyconverter.data.local.model.CurrencyDto
import ru.myproject.currencyconverter.data.remote.api.RetrofitInstance
import ru.myproject.currencyconverter.data.remote.model.CurrencyResponse

class CurrencyLocalDataSource(private val db: CurrencyDatabase) {

    suspend fun insertAll(currencyList: List<CurrencyDto>) =
        db.getCurrencyDao().insert(currencyList)

    suspend fun getAll(): List<CurrencyDto> = db.getCurrencyDao().getAll()

}


