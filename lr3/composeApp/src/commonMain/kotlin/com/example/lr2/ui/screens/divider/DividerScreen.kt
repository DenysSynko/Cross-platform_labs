package com.example.lr2.ui.screens.divider

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DividerScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Button(onClick = { navController.navigateUp() }) {
            Text("Back")
        }

        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Above divider")
                Divider(modifier = Modifier.padding(vertical = 12.dp))
                Text("Below divider")
            }
        }
    }
}