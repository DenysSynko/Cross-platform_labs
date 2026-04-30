package com.example.lr2.ui.screens.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DialogScreen(navController: NavHostController) {

    var show by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Button(onClick = { navController.navigateUp() }) {
            Text("Back")
        }

        Button(onClick = { show = true }) {
            Text("Show dialog")
        }
    }

    if (show) {
        AlertDialog(
            onDismissRequest = { show = false },
            title = { Text("Dialog Example") },
            text = { Text("This is a basic dialog") },
            confirmButton = {
                TextButton(onClick = { show = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { show = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}