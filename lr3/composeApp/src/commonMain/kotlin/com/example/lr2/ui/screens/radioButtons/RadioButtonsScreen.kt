package com.example.lr2.ui.screens.radioButtons

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun RadioButtonsScreen(navController: NavHostController) {

    var selected by remember { mutableStateOf("A") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = { navController.navigateUp() }) {
            Text("Back")
        }

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            RadioButton(
                selected = selected == "A",
                onClick = { selected = "A" }
            )
            Text("Option A", modifier = Modifier.padding(start = 8.dp))
        }

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            RadioButton(
                selected = selected == "B",
                onClick = { selected = "B" }
            )
            Text("Option B", modifier = Modifier.padding(start = 8.dp))
        }

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            RadioButton(
                selected = false,
                onClick = {},
                enabled = false
            )
            Text("Disabled option", modifier = Modifier.padding(start = 8.dp))
        }


    }
}