package com.example.sfeduhelper.view.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteSpecialtyPage(navController: NavController, viewModel: UserViewModel){
    val background = painterResource(R.drawable.main_background)

    var selectedItems = remember { mutableStateListOf<Int>() }

    Image(
        painter = background,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )

    Scaffold (
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                title = { Text("Ваш профиль", fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ){
        paddingValues ->
        Box{
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                var selectedDirections =
                    //viewModel.getSelectedCodeDirections()
                    List(3) { "Элемент ${it + 1}" }

                Text(
                    "Выбранные специальности:"
                )
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(selectedDirections.size) { index ->
                        val isSelected = selectedItems.contains(index)
                        ListItem(
                            headlineContent = { Text(text = selectedDirections[index]) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    if (isSelected) {
                                        selectedItems.remove(index)
                                    } else
                                        selectedItems.add(index)
                                }
                                .background(
                                    if (isSelected) Color.LightGray else Color.Transparent
                                )
                                .padding(16.dp)
                        )
                    }
                }
            }

            val context = LocalContext.current

            Button(
                onClick = { Toast.makeText(context, "Упс! Эта кнопка ещё не работает.", Toast.LENGTH_LONG).show() },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = 60.dp, start = 10.dp, end = 10.dp)
            ) {
                Text("Удалить")
            }
        }
    }
}