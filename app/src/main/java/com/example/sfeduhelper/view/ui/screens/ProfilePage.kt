package com.example.sfeduhelper.view.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    val background = painterResource(R.drawable.background_sfedu)

    Image(
        painter = background,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
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
        val selectedDirections = viewModel.getSelectedCodeDirections()//List(3) { "Элемент ${it + 1}" }

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(selectedDirections) { item ->
                TextItem(text = item)
            }
        }
        Button(
            onClick = { navController.navigate("AddSpecialtyPage")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp)
        ) {
            Text(
                text = "Добавить",
                modifier = Modifier.padding(8.dp)
            )
        }
        Button(
            onClick = { navController.navigate("DeleteSpecialtyPage")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp)
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

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = settingsIcon,
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            TextButton(
                onClick = {navController.navigate("SettingsPage")}
            ) {
                Text(text = "Настройки")
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = sfeduIcon,
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            TextButton(
                onClick = {navController.navigate("LinksPage")}
            ) {
                Text(text = "Полезные ссылки")
            }
        }
        Spacer(modifier = Modifier.height(180.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
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