package com.example.lr6

import com.example.lr6.di.initKoin
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()

    document.getElementById("loading-indicator")?.setAttribute("style", "display: none;")
    ComposeViewport {
        App()
    }
}