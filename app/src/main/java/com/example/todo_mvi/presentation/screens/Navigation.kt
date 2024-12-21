package com.example.todo_mvi.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo_mvi.presentation.viewmodel.MainActivityViewModel

object Navigation {
    val SPLASH_SCREEN = "SplashScreen"
    val HOME_SCREEN = "HomeScreen"
}

@Composable
fun Onboarding(mainViewmodel: MainActivityViewModel) {
    val navController =  rememberNavController()

    NavHost(navController = navController, startDestination = Navigation.SPLASH_SCREEN) {
        composable(Navigation.SPLASH_SCREEN) {
            SplashScreen(navController)
        }
        composable(Navigation.HOME_SCREEN) {
            HomeScreen(navController, mainViewmodel)
        }
    }
}