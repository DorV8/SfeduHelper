package com.example.sfeduhelper.view.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun MainMenuPage(navController: NavController, viewModel: UserViewModel){

    var pickedPage by remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box (
            modifier = Modifier.padding(bottom = 40.dp)
        ) {
            when (pickedPage) {
                1 -> HomeScreen(navController, viewModel)
                2 -> CalculatorScreen(navController, viewModel)
                3 -> NewsScreen(navController, viewModel)
            }
        }

        //переделать, чтобы было нормальное разрешение картинок
        Row (
            modifier = Modifier
                .height(85.dp)
                .align(Alignment.BottomCenter)
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(bottom = 50.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            Image(
                painter = painterResource(R.drawable.grid),
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        pickedPage = 1
                    }
                    .height(50.dp)
                    .width(50.dp)
            )

            Image(
                painter = painterResource(R.drawable.calculator),
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        pickedPage = 2
                    }
                    .height(50.dp)
                    .width(50.dp)
            )

            Image(
                painter = painterResource(R.drawable.news),
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                            pickedPage = 3
                    }
                    .height(50.dp)
                    .width(50.dp)
            )
        }
    }
}


