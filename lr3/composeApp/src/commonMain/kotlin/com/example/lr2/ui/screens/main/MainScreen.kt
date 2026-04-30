package com.example.lr2.ui.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(nav: NavHostController) {

    val buttons = listOf(
        "Buttons" to "buttons",
        "Checkboxes" to "checkboxes",
        "Chips" to "chips",
        "Datepicker dialog" to "datepicker",
        "Dialog" to "dialog",
        "Divider" to "divider",
        "Progress bar" to "progress",
        "Radio buttons" to "radio",
        "Switch" to "switch",
        "Timepicker dialog" to "timepicker"
    )

    LazyColumn(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(buttons) { (title, route) ->
            Button(onClick = { nav.navigate(route) }) {
                Text(title)
            }
        }
    }
}