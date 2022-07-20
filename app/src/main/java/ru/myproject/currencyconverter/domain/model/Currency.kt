package ru.myproject.currencyconverter.domain.model

data class Currency(
    val charcode: String,
    val nominal: Int,
    val name: String,
    val value: Double,
    val difference: Double
)