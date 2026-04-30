package com.example.lr2.ui.screens.switch

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SwitchScreen(navController: NavHostController) {

    var enabled1 by remember { mutableStateOf(false) }
    var enabled2 by remember { mutableStateOf(true) }
    var enabled3 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Button(onClick = { navController.navigateUp() }) {
            Text("Back")
        }

        Text("Basic Switches", style = MaterialTheme.typography.titleMedium)

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Switch(
                checked = enabled1,
                onCheckedChange = { enabled1 = it }
            )
            Text(
                text = if (enabled1) "Enabled" else "Disabled",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Switch(
                checked = enabled2,
                onCheckedChange = { enabled2 = it }
            )
            Text(
                text = "Default ON",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Switch(
                checked = false,
                onCheckedChange = {},
                enabled = false
            )
            Text(
                text = "Disabled switch",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Divider()

        Text("Grouped Switches", style = MaterialTheme.typography.titleMedium)

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Switch(
                checked = enabled1 && enabled2,
                onCheckedChange = {
                    enabled1 = it
                    enabled2 = it
                }
            )
            Text(
                text = "Master switch",
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}