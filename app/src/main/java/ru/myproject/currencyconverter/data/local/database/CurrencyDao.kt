package ru.myproject.currencyconverter.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.myproject.currencyconverter.data.local.model.CurrencyDto

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM table_currency")
    fun getAll(): Flow<List<CurrencyDto>>

    @Insert
    fun insertAll(vararg currencies: CurrencyDto)

    @Query("DELETE FROM table_currency")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM table_currency")
    fun getCount(): Int
}
