package com.example.livecurrency.db

import androidx.room.*
import com.example.livecurrency.model.CurrencyEntity
import com.example.livecurrency.model.QuoteEntity

@Dao
interface QuoteDao {
  @Query("SELECT * FROM quoteentity")
  fun getAll(): List<QuoteEntity>

  @Query("SELECT * FROM quoteentity WHERE `to` LIKE :code LIMIT 1")
  fun findByCode(code: String): QuoteEntity

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun insert(entity: QuoteEntity): Long

  @Update(onConflict = OnConflictStrategy.REPLACE)
  fun update(entity: QuoteEntity)

  @Transaction
  fun upsert(entity: QuoteEntity) {
    val id = insert(entity)
    if (id == -1L) {
      update(entity)
    }
  }
}