package com.example.myapplication.utilities

import com.example.myapplication.data.FakeDatabase
import com.example.myapplication.data.QuoteRepository
import com.example.myapplication.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}