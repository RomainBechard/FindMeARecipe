package com.romainbechard.findmearecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.romainbechard.findmearecipe.ui.screens.home.HomeScreen
import com.romainbechard.findmearecipe.ui.screens.settings.SettingsScreen
import com.romainbechard.findmearecipe.ui.theme.FindMeARecipeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FindMeARecipeTheme {
                FindMeARecipeApp()
            }
        }
    }
}

@Composable
fun FindMeARecipeApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(navController)
        }
        composable(route = "settings") {
            SettingsScreen(navController = navController)
        }
    }
}