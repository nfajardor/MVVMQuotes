package com.example.myapplication.data

data class Quote(val quoteText: String, val author: String) {


    override fun toString(): String{
        return "$quoteText - $author"
    }
}