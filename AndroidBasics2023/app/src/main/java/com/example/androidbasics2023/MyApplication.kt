package com.example.androidbasics2023

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // context in application is not destroyed as long as the app is running
        val myContext: Context = this
    }
}