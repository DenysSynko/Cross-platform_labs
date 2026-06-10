package com.example.lr6

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.lr6.di.appModule
import org.koin.core.context.startKoin
import com.example.lr6.di.dataModule
import com.example.lr6.di.initKoin

fun main() {
    initKoin()

    application {
        Window(onCloseRequest = ::exitApplication) {
            App()
        }
    }
}