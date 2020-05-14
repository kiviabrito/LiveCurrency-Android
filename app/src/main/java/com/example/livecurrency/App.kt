package com.example.livecurrency

import android.app.Application
import androidx.room.Room
import com.example.livecurrency.db.AppDatabase
import com.example.livecurrency.utility.ClientApi

class App: Application() {

    companion object {
        lateinit var instance: App

        lateinit var db : AppDatabase

        val clientApi: ClientApi by lazy {
            ClientApi()
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        db = AppDatabase.getInstance(this)
    }
}