package com.example.lr2

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.lr2.ui.screens.AppNavigation
import com.example.lr2.ui.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        AppNavigation()
    }
}