package com.example.exam6.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import com.example.exam6.R

class SecondActivity : AppCompatActivity() {

    lateinit var iv_back_to_main: ImageView
    lateinit var et_cardNumber: EditText
    lateinit var et_cardMonth:EditText
    lateinit var et_cardYear:EditText
    lateinit var et_cardCvv:EditText
    lateinit var et_cardHolderName:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()
    }

    private fun initViews() {
        iv_back_to_main = findViewById(R.id.iv_back_to_main)
        et_cardNumber = findViewById(R.id.et_card_number)
        et_cardMonth = findViewById(R.id.et_card_month)
        et_cardYear = findViewById(R.id.et_card_year)
        et_cardCvv = findViewById(R.id.et_card_cvv)
        et_cardHolderName = findViewById(R.id.et_card_holder_name)

        iv_back_to_main.setOnClickListener {
            finish()
        }
    }

}