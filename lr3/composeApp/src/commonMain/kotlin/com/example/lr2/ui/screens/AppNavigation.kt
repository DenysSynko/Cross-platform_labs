package com.example.lr2.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lr2.ui.screens.main.MainScreen
import com.example.lr2.ui.screens.buttons.ButtonsScreen
import com.example.lr2.ui.screens.checkboxes.CheckboxesScreen
import com.example.lr2.ui.screens.chips.ChipsScreen
import com.example.lr2.ui.screens.datepickerDialog.DatePickerScreen
import com.example.lr2.ui.screens.dialog.DialogScreen
import com.example.lr2.ui.screens.divider.DividerScreen
import com.example.lr2.ui.screens.progressBar.ProgressBarScreen
import com.example.lr2.ui.screens.radioButtons.RadioButtonsScreen
import com.example.lr2.ui.screens.switch.SwitchScreen
import com.example.lr2.ui.screens.timepickerDialog.TimePickerScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {

        composable("main") {
            MainScreen(navController)
        }

        composable("buttons") {
            ButtonsScreen(navController)
        }

        composable("checkboxes") {
            CheckboxesScreen(navController)
        }

        composable("chips") {
            ChipsScreen(navController)
        }

        composable("datepicker") {
            DatePickerScreen(navController)
        }

        composable("dialog") {
            DialogScreen(navController)
        }

        composable("divider") {
            DividerScreen(navController)
        }

        composable("progress") {
            ProgressBarScreen(navController)
        }

        composable("radio") {
            RadioButtonsScreen(navController)
        }

        composable("switch") {
            SwitchScreen(navController)
        }

        composable("timepicker") {
            TimePickerScreen(navController)
        }
    }
}