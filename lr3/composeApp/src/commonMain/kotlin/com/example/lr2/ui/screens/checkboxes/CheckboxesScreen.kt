package com.example.lr2.ui.screens.checkboxes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.state.ToggleableState
import androidx.compose.material3.TriStateCheckbox

@Composable
fun CheckboxesScreen(navController: NavHostController) {
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(true) }

    val parentState = when {
        child1 && child2 -> ToggleableState.On
        !child1 && !child2 -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Button(onClick = { navController.navigateUp() }) {
            Text("Back")
        }


        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newValue = parentState != ToggleableState.On
                    child1 = newValue
                    child2 = newValue
                }
            )
            Text("Select all", modifier = Modifier.padding(start = 8.dp))
        }


        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = child1,
                onCheckedChange = { child1 = it }
            )
            Text("Option 1", modifier = Modifier.padding(start = 8.dp))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = child2,
                onCheckedChange = { child2 = it }
            )
            Text("Option 2 (default checked)", modifier = Modifier.padding(start = 8.dp))
        }
    }
}