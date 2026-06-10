package com.example.lr6
import com.example.lr6.di.initKoin

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Lr6",
    ) {
        App()
    }
}
