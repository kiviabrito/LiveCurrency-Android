package com.example.livecurrency.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.livecurrency.model.CurrencyEntity
import com.example.livecurrency.model.QuoteEntity

@Database(entities = [
  QuoteEntity::class,
  CurrencyEntity::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {

  abstract fun currencyDao(): CurrencyDao
  abstract fun quoteDao(): QuoteDao

  companion object {

    @Volatile private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase =
      INSTANCE ?: synchronized(this) {
        INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
      }

    private fun buildDatabase(context: Context) =
      Room.databaseBuilder(context.applicationContext,
        AppDatabase::class.java, "mobile-challenge.db")
        .build()
  }
}