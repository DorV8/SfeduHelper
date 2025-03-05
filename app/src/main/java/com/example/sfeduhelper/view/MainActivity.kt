package com.example.sfeduhelper.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.sfeduhelper.navigation.NavigationApp
import com.example.sfeduhelper.view.ui.theme.SfeduHelperTheme
import com.example.sfeduhelper.viewmodel.UserViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SfeduHelperTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = UserViewModel()
                    viewModel.setDirections()
                    viewModel.setLinks()
                    viewModel.setFAQ()
                    viewModel.addNewsSamples()

                    viewModel.addInfoSamples()

                    NavigationApp(viewModel)
                }
            }
        }
    }
}




