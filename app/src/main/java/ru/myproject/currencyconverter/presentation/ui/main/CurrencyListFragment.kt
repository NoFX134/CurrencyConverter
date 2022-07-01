package ru.myproject.currencyconverter.presentation.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.myproject.currencyconverter.databinding.FragmentCurrencyConverterBinding
import ru.myproject.currencyconverter.databinding.FragmentCurrencyListBinding
import ru.myproject.currencyconverter.domain.model.Currency
import ru.myproject.currencyconverter.presentation.adapters.CurrencyAdapter

class CurrencyListFragment : Fragment() {

    companion object {

        fun newInstance() = CurrencyListFragment()
    }

    private val viewModel: CurrencyListViewModel by viewModels()
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
        Log.d("qwerty", "qwerty")
        setupRecycleView()
        currencyAdapter.submitList(Currency.currencyList)
    }

    private fun setupRecycleView() {
        currencyAdapter = CurrencyAdapter()
        binding.rvCurrency.apply {
            adapter = currencyAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}