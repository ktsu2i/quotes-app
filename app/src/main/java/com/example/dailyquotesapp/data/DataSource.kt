package com.example.dailyquotesapp.data

import com.example.dailyquotesapp.R
import com.example.dailyquotesapp.model.Quote

class DataSource {
    fun loadQuotes(): List<Quote>
    {
        return listOf<Quote>(
            Quote(R.string.author1, R.string.quotes1, R.drawable.authorimage1),
            Quote(R.string.author2, R.string.quotes2, R.drawable.authorimage2),
            Quote(R.string.author3, R.string.quotes3, R.drawable.authorimage3),
            Quote(R.string.author4, R.string.quotes4, R.drawable.authorimage4),
            Quote(R.string.author5, R.string.quotes5, R.drawable.authorimage5),
            Quote(R.string.author6, R.string.quotes6, R.drawable.authorimage6),
            Quote(R.string.author7, R.string.quotes7, R.drawable.authorimage7),
            Quote(R.string.author8, R.string.quotes8, R.drawable.authorimage8),
            Quote(R.string.author9, R.string.quotes9, R.drawable.authorimage9),
            Quote(R.string.author10, R.string.quotes10, R.drawable.authorimage10),
        )
    }
}