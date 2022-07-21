package ru.myproject.currencyconverter.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.myproject.currencyconverter.data.local.model.CurrencyDto

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM table_currency")
    suspend fun getAll(): List<CurrencyDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currencyList: List<CurrencyDto>)


}
