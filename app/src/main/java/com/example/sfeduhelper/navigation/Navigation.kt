package com.example.sfeduhelper.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sfeduhelper.view.ui.screens.AddSpecialtyPage
import com.example.sfeduhelper.view.ui.screens.DeleteSpecialtyPage
import com.example.sfeduhelper.view.ui.screens.LinksPage
import com.example.sfeduhelper.view.ui.screens.MainMenuPage
import com.example.sfeduhelper.view.ui.screens.ProfilePage
import com.example.sfeduhelper.view.ui.screens.SecondScreen
import com.example.sfeduhelper.view.ui.screens.SettingsPage
import com.example.sfeduhelper.view.ui.screens.StartScreen
import com.example.sfeduhelper.viewmodel.UserViewModel


@Composable
fun NavigationApp(viewModel: UserViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "StartScreen"
    ) {
        composable("StartScreen") { StartScreen(navController, viewModel) }
        composable("SecondScreen") { SecondScreen(navController, viewModel) }

        composable("ProfilePage") { ProfilePage(navController, viewModel) }

        composable("AddSpecialtyPage") { AddSpecialtyPage(navController, viewModel) }
        composable("DeleteSpecialtyPage") { DeleteSpecialtyPage(navController, viewModel)}

        composable("SettingsPage") { SettingsPage(navController, viewModel)}
        composable("LinksPage") { LinksPage(navController, viewModel) }

        composable("MainMenuPage") { MainMenuPage(navController, viewModel) }
    }
}