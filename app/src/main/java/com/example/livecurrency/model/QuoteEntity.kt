package com.example.livecurrency.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class QuoteEntity(
  @PrimaryKey
  val _id : Int,
  val from: String,
  val to: String,
  val value: Double
)