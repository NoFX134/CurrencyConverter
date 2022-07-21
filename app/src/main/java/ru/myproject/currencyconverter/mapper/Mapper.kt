package ru.myproject.currencyconverter.mapper

import ru.myproject.currencyconverter.data.local.model.CurrencyDto
import ru.myproject.currencyconverter.data.remote.model.CurrencyRemote
import ru.myproject.currencyconverter.domain.model.Currency

object Mapper {

    fun dtoToCurrency(currencyDto: CurrencyDto): CurrencyRemote {
        return CurrencyRemote(
            id = currencyDto.id,
            numCode = currencyDto.numCode,
            charCode = currencyDto.charCode,
            nominal = currencyDto.nominal,
            name = currencyDto.name,
            value = currencyDto.value,
            previousValue = currencyDto.previousValue
        )
    }

    fun currencyToDto(currency: CurrencyRemote): CurrencyDto {
        return CurrencyDto(
            id = currency.id,
            numCode = currency.numCode,
            charCode = currency.charCode,
            nominal = currency.nominal,
            name = currency.name,
            value = currency.value,
            previousValue = currency.previousValue
        )


    }

    fun currencyDtoToCurrency(currency: CurrencyDto): Currency {
        return Currency(
            id = currency.id,
            charCode = currency.charCode,
            nominal = currency.nominal,
            name = currency.name,
            value = currency.value,
            difference = currency.value-currency.previousValue
        )
    }
}