package ru.myproject.currencyconverter.presentation.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import ru.myproject.currencyconverter.R
import ru.myproject.currencyconverter.data.CurrencyRepositoryImpl
import ru.myproject.currencyconverter.data.local.database.CurrencyDatabase
import ru.myproject.currencyconverter.data.local.datasource.CurrencyLocalDataSource
import ru.myproject.currencyconverter.data.remote.datasource.CurrencyRemoteDataSource

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: CurrencyListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CurrencyListFragment.newInstance())
                .commitNow()
        }
    }
}