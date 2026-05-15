package com.example.lr6

import androidx.compose.runtime.*
import com.example.lr6.theme.MyCustomTheme
import com.example.lr6.ui.about.AboutScreen
import com.example.lr6.data.about.Platform

@Composable
fun App() {
    MyCustomTheme {
        AboutScreen(
            onBack = { }
        )
    }
}