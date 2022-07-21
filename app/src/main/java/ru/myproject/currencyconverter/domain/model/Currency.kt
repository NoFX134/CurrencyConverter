package ru.myproject.currencyconverter.domain.model

data class Currency(
    val id: String,
    val charCode: String,
    val nominal: Int,
    val name: String,
    val value: Double,
    val difference: Double

)