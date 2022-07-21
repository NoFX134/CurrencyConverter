package ru.myproject.currencyconverter.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.myproject.currencyconverter.domain.model.Currency

@Entity(tableName = "table_currency")
data class CurrencyDto(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "num_code")
    val numCode: String,
    @ColumnInfo(name = "char_code")
    val charCode: String,
    val nominal: Int,
    val name: String,
    val value: Double,
    @ColumnInfo(name = "previous_value")
    val previousValue: Double
) {

    fun currencyDtoToCurrency(currency: CurrencyDto): Currency {
        return Currency(
            id = currency.id,
            charCode = currency.charCode,
            nominal = currency.nominal,
            name = currency.name,
            value = currency.value,
            difference = currency.value - currency.previousValue
        )
    }
}