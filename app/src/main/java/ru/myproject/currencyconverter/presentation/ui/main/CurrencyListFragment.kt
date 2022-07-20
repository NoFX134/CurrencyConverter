package ru.myproject.currencyconverter.presentation.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import ru.myproject.currencyconverter.data.CurrencyRepositoryImpl
import ru.myproject.currencyconverter.data.remote.datasource.CurrencyRemoteDataSource
import ru.myproject.currencyconverter.databinding.FragmentCurrencyListBinding
import ru.myproject.currencyconverter.presentation.adapters.CurrencyAdapter
import ru.myproject.currencyconverter.util.Resource

class CurrencyListFragment : Fragment() {

    companion object {

        fun newInstance() = CurrencyListFragment()
    }

    private lateinit var viewModel: CurrencyListViewModel
    private lateinit var binding: FragmentCurrencyListBinding
    private lateinit var currencyAdapter: CurrencyAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currencyRepository = CurrencyRepositoryImpl(CurrencyRemoteDataSource(Dispatchers.IO))
        val viewModelProviderFactory = CurrencyListViewModelProviderFactory(currencyRepository)
        viewModel =
            ViewModelProvider(this, viewModelProviderFactory)[CurrencyListViewModel::class.java]
        setupRecycleView()

        viewModel.currency.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    Log.d("111", "Hello")
                    response.data.let { currencyResponse ->
                        if (currencyResponse != null) {
                            currencyAdapter.submitList(currencyResponse.valute.values.toMutableList())
                            Log.d("111", currencyResponse.valute.values.toString())
                        }
                    }
                }

                else -> {
                    Log.d("111", "hi")
                }
            }
        }
    }

    private fun setupRecycleView() {
        currencyAdapter = CurrencyAdapter()
        binding.rvCurrency.apply {
            adapter = currencyAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}