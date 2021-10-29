package com.example.myapplication.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Quote
import com.example.myapplication.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)



}