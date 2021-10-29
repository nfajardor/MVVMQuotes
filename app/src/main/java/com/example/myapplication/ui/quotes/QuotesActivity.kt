package com.example.myapplication.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.data.Quote
import com.example.myapplication.utilities.InjectorUtils
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUI()
    }

    private fun initializeUI(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory).get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            val textView_quotes = findViewById<TextView>(R.id.textView_quotes)
            textView_quotes.text = stringBuilder.toString()
        })

        val button_add_quote = findViewById<Button>(R.id.button_add_quote)
        button_add_quote.setOnClickListener{
            val editText_quote = findViewById<EditText>(R.id.editText_quote)
            val editText_author = findViewById<EditText>(R.id.editText_author)
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_author.setText("")
            editText_quote.setText("")
        }

    }
}