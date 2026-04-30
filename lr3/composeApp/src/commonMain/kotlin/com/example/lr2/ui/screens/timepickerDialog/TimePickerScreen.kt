package com.example.lr2.ui.screens.timepickerDialog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.graphics.graphicsLayer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerScreen(navController: NavHostController) {

    var dialogOpen by remember { mutableStateOf(false) }

    val timeState = rememberTimePickerState()

    var selectedTimeText by remember {
        mutableStateOf("No time selected")
    }

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
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text = "Selected time",
                    style = MaterialTheme.typography.labelMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = selectedTimeText,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        Button(onClick = { dialogOpen = true }) {
            Text("Select time")
        }
    }
    if (dialogOpen) {
        Dialog(onDismissRequest = { dialogOpen = false }) {
            Card {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .widthIn(min = 320.dp)
                ) {

                    Text("Select time")

                    TimePicker(
                        state = timeState,
                        modifier = Modifier
                            .graphicsLayer(scaleX = 0.9f, scaleY = 0.9f)
                    )

                    Row {
                        TextButton(onClick = { dialogOpen = false }) {
                            Text("Cancel")
                        }

                        TextButton(onClick = {
                            dialogOpen = false

                            val hour = timeState.hour.toString().padStart(2, '0')
                            val minute = timeState.minute.toString().padStart(2, '0')

                            selectedTimeText = "$hour:$minute"
                        }) {
                            Text("OK")
                        }
                    }
                }
            }
        }
    }
}