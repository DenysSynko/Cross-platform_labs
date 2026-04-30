package com.example.lr2.ui.screens.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ButtonsScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Button(onClick = { navController.navigateUp() }) {
            Text("Back")
        }

        Button(onClick = {}) { Text("Standard Button") }
        ElevatedButton(onClick = {}) { Text("Elevated Button") }
        OutlinedButton(onClick = {}) { Text("Outlined Button") }
        TextButton(onClick = {}) { Text("Text Button") }
    }
}