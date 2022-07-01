package ru.myproject.currencyconverter.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.myproject.currencyconverter.databinding.FragmentCurrencyConverterBinding

class CurrencyConverterFragment : Fragment() {

    companion object {

        fun newInstance() = CurrencyConverterFragment()
    }

    private lateinit var binding: FragmentCurrencyConverterBinding
    private val viewModel: CurrencyConverterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyConverterBinding.inflate(inflater, container,false)
        return binding.root
    }



}