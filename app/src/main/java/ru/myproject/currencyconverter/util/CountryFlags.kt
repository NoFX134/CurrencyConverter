package ru.myproject.currencyconverter.util

data class CountryFlags(
    val flagsMap: Map<String, String> = mapOf<String, String>(
        "AUD" to "https://upload.wikimedia.org/wikipedia/commons/8/88/Flag_of_Australia_%28converted%29.svg",
        "AZN" to "https://upload.wikimedia.org/wikipedia/commons/d/dd/Flag_of_Azerbaijan.svg",
        "GBP" to "https://upload.wikimedia.org/wikipedia/commons/a/ae/Flag_of_the_United_Kingdom.svg",
        "AMD" to "https://upload.wikimedia.org/wikipedia/commons/2/2f/Flag_of_Armenia.svg",
        "RON" to "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Flag_of_Romania.svg/320px-Flag_of_Romania.svg.png?uselang=ru",
        "XDR" to "https://upload.wikimedia.org/wikipedia/ru/3/3d/%D0%9C%D0%B5%D0%B6%D0%B4%D1%83%D0%BD%D0%B0%D1%80%D0%BE%D0%B4%D0%BD%D1%8B%D0%B9_%D0%B2%D0%B0%D0%BB%D1%8E%D1%82%D0%BD%D1%8B%D0%B9_%D1%84%D0%BE%D0%BD%D0%B4.png"

    )
)
{
    fun getFlags(charCode: String)= flagsMap[charCode]
}
