package com.example.lr6

import android.app.Application
import org.koin.android.ext.koin.androidContext
import com.example.lr6.di.initKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@AppApplication)
        }
    }
}