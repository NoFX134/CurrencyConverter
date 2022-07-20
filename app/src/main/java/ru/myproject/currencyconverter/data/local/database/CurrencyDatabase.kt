package ru.myproject.currencyconverter.data.local.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class CurrencyDatabase : RoomDatabase() {
    abstract fun getCurrencyDao(): CurrencyDao

    companion object {
        @Volatile
        private var instance: CurrencyDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, CurrencyDatabase::class.java,
                "article_db.db"
            ).build()
    }
}