package com.example.exam6.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class CardName(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val cardNumber: String,
    val cardMonth: String,
    val cardYear: String,
    val cardSvv: String,
    val hplderName: String,

)