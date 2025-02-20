package com.example.sfeduhelper.view.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun SecondScreen(navController: NavController, viewModel: UserViewModel){
    val background = painterResource(R.drawable.start_background)

    Image(
        painter = background,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Выберите свой вариант:",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = { navController.navigate("MainMenuPage")},
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonColors(
                containerColor = viewModel.getRGBColor(143, 74, 234),
                contentColor = Color.White,
                disabledContainerColor = viewModel.getRGBColor(143, 74, 234),
                disabledContentColor = Color.White
            )
        ) {
            Text(text = "Я хочу узнать о специальностях", textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { navController.navigate("AddSpecialtyPage")},
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonColors(
                containerColor = viewModel.getRGBColor(143, 74, 234),
                contentColor = Color.White,
                disabledContainerColor = viewModel.getRGBColor(143, 74, 234),
                disabledContentColor = Color.White
            )
        ) {
            Text(text = "Я уже выбрал подходящие специальности", textAlign = TextAlign.Center)
        }

        Text(
            text = "Если вы первокурсник, то можете выбрать любой вариант и в дальнейшем авторизоваться в настройках.",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
    }
}