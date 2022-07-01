package ru.myproject.currencyconverter.domain.model

data class Currency(
    val charcode: String,
    val nominal: Int,
    val name: String,
    val value: Double,
    val difference: Double
) {

    companion object {

        val currencyList: MutableList<Currency> = mutableListOf()

        init {
            for (i in 0..10) {
                currencyList.add(
                    Currency(
                        charcode = "USD$i",
                        nominal = i,
                        name = "Доллар$i",
                        value = 10.00 + i,
                        difference = i.toDouble() - 5
                    )
                )
            }
        }

    }

}