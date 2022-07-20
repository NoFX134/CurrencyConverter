package ru.myproject.currencyconverter.data.remote.model

import com.google.gson.annotations.SerializedName

data class CurrencyRemote(
    @SerializedName("ID")
    var id: String,
    @SerializedName("NumCode")
    var numCode: String,
    @SerializedName("CharCode")
    var charCode: String,
    @SerializedName("Nominal")
    var nominal: Int,
    @SerializedName("Name")
    var name: String,
    @SerializedName("Value")
    var value: Double,
    @SerializedName("Previous")
    var previousValue: Double

)