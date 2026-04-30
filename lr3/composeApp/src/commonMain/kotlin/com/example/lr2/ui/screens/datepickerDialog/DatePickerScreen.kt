package com.example.lr2.ui.screens.datepickerDialog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.datetime.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerScreen(navController: NavHostController) {

    var dialogOpen by remember { mutableStateOf(false) }

    val dateState = rememberDatePickerState()
    var selectedDateText by remember { mutableStateOf("No date selected") }

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Button(onClick = { navController.navigateUp() }) {
            Text("Back")
        }

        Text(
            text = selectedDateText,
            style = MaterialTheme.typography.bodyLarge
        )

        Button(onClick = { dialogOpen = true }) {
            Text("Select date")
        }

        if (dialogOpen) {
            DatePickerDialog(
                onDismissRequest = { dialogOpen = false },
                confirmButton = {
                    TextButton(onClick = {
                        dialogOpen = false

                        val millis = dateState.selectedDateMillis
                        if (millis != null) {
                            val instant = Instant.fromEpochMilliseconds(millis)
                            val localDate = instant.toLocalDateTime(TimeZone.currentSystemDefault()).date

                            selectedDateText =
                                "${localDate.dayOfMonth.toString().padStart(2, '0')}." +
                                        "${localDate.monthNumber.toString().padStart(2, '0')}." +
                                        localDate.year.toString()
                        }

                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { dialogOpen = false }) {
                        Text("Cancel")
                    }
                }
            ) {
                DatePicker(state = dateState)
            }
        }
    }
}