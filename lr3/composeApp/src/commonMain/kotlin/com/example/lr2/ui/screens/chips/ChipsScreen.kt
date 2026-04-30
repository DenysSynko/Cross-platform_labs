package com.example.lr2.ui.screens.chips

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ChipsScreen(navController: NavHostController) {

    var assistSelected by remember { mutableStateOf(false) }
    var filterSelected by remember { mutableStateOf(false) }
    var inputEnabled by remember { mutableStateOf(true) }
    var suggestionPressed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Button(onClick = { navController.navigateUp() }) {
            Text("Back")
        }

        AssistChip(
            onClick = { assistSelected = !assistSelected },
            label = { Text(if (assistSelected) "Assist: Selected" else "Assist: Tap me") }
        )

        FilterChip(
            selected = filterSelected,
            onClick = { filterSelected = !filterSelected },
            label = { Text(if (filterSelected) "Filter: ON" else "Filter: OFF") }
        )

        InputChip(
            selected = inputEnabled,
            onClick = { inputEnabled = !inputEnabled },
            label = { Text(if (inputEnabled) "Input active" else "Disabled") }
        )

        SuggestionChip(
            onClick = { suggestionPressed = !suggestionPressed },
            label = { Text(if (suggestionPressed) "Suggested" else "Suggestion") }
        )
    }
}