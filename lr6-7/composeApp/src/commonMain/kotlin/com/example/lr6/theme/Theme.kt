package com.example.lr6.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

@Composable
fun MyCustomTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = PrimaryAccent,
            secondary = SecondaryAccent,
            background = BackgroundDark,
            surface = SurfaceDark,
            onPrimary = BackgroundDark,
            onBackground = TextPrimary,
            onSurface = TextPrimary
        ),
        content = content
    )
}