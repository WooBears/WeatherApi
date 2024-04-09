package com.example.weatherapp

import android.app.Application
import androidx.room.Room
import com.example.weatherapp.data.db.AppDatabase
import dagger.hilt.android.HiltAndroidApp

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "weather"
        ).allowMainThreadQueries().build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}