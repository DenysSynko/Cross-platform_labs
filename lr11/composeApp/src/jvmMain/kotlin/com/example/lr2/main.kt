package com.example.lr2

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.lr2.di.initKoin

fun main() {
    initKoin()
    application { Window(onCloseRequest = ::exitApplication) { App() } }
}