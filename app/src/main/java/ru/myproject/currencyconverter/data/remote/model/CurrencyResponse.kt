package ru.myproject.currencyconverter.data.remote.model

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @SerializedName("PreviousURL")
    val previousURL: String? = null,
    @SerializedName("Timestamp")
    val timestamp: String? = null,
    @SerializedName("Date")
    val date: String? = null,
    @SerializedName("PreviousDate")
    val previousDate: String? = null,
    @SerializedName("CurrencyRemote")
    val valute: Map<String, CurrencyRemote>
)