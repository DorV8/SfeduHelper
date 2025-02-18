package com.example.sfeduhelper.view.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun ProfilePage(navController: NavController, viewModel: UserViewModel) {

    var showDialog by remember { mutableStateOf(false)}
    BackHandler(enabled = true) {
        showDialog = true
    }
    if (showDialog) { }

    val background = painterResource(R.drawable.main_background)

    Image(
        painter = background,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Профиль",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 40.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Выбранные специальности:"
            )
            val selectedDirections =
                viewModel.getSelectedCodeDirections()//List(3) { "Элемент ${it + 1}" }

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(selectedDirections) { item ->
                    TextItem(text = item)
                }
            }

            Button(
                onClick = { navController.navigate("AddSpecialtyPage") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp),
                colors = ButtonColors(
                    containerColor = viewModel.getRGBColor(143, 74, 234),
                    contentColor = Color.White,
                    disabledContainerColor = viewModel.getRGBColor(143, 74, 234),
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    text = "Добавить",
                    modifier = Modifier.padding(8.dp)
                )
            }
            Button(
                onClick = { navController.navigate("DeleteSpecialtyPage") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp),
                colors = ButtonColors(
                    containerColor = viewModel.getRGBColor(143, 74, 234),
                    contentColor = Color.White,
                    disabledContainerColor = viewModel.getRGBColor(143, 74, 234),
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    text = "Удалить",
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(
                modifier = Modifier.padding(top = 20.dp)
            )

            val settingsIcon = painterResource(R.drawable.settings_icon)
            val sfeduIcon = painterResource(R.drawable.sfedu_icon)

            //сделать одинаковую длину
            CustomTextButton(
                "Настройки",
                Icons.Default.Settings,
                color = viewModel.getRGBColor(143, 74, 234),
                onClick = { navController.navigate("SettingsPage") }
            )

            CustomTextButton(
                "Полезные ссылки",
                Icons.Default.Info,
                color = viewModel.getRGBColor(143, 74, 234),
                onClick = { navController.navigate("LinksPage") }
            )
        }
        Button(
            onClick = { navController.navigate("MainMenuPage")},
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 60.dp, start = 10.dp, end = 10.dp),
            colors = ButtonColors(
                containerColor = viewModel.getRGBColor(143, 74, 234),
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = viewModel.getRGBColor(143, 74, 234)
            )
        ) {
            Text(text = "Закончить настройку")
        }
    }
}

@Composable
fun TextItem(text: String) {
    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.surfaceVariant,
            shadowElevation = 2.dp
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun CustomTextButton(
    text: String,
    icon: ImageVector, // Иконка
    color: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(2.dp),
        shape = RoundedCornerShape(12.dp), // Скруглённые углы
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent, // Прозрачный фон
            contentColor = Color.Black // Фиолетовый цвет текста и иконки
        ),
        border = BorderStroke(2.dp, color)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null, // Описание для доступности
                tint = color // Цвет иконки
            )
            Spacer(modifier = Modifier.width(4.dp)) // Отступ между иконкой и текстом
            Text(
                text = text,
                fontWeight = FontWeight.Bold // Полужирный текст
            )
        }
    }
}