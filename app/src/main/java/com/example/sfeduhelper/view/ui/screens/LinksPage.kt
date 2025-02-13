package com.example.sfeduhelper.view.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun LinksPage(navController: NavController, viewModel: UserViewModel){
    Column {
        Button(
            onClick = {navController.popBackStack()}
        ) {
            Text(
                text = "Get back"
            )
        }
    }
}