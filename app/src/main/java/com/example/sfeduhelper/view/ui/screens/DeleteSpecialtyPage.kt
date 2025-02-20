package com.example.sfeduhelper.view.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteSpecialtyPage(navController: NavController, viewModel: UserViewModel){
    val background = painterResource(R.drawable.main_background)

    Image(
        painter = background,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )

    var selectedDirections =
        viewModel.getSelectedCodeDirections()
    var selectedDirectionsPriorities = viewModel.getPriorities()

    var selectedItems = remember { mutableStateListOf<String>() }

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

                Text(
                    "Выбранные специальности:"
                )

                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(selectedDirections) { item ->
                        val isSelected = selectedItems.contains(item)

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(24.dp))
                                .background(
                                    brush = Brush.linearGradient(
                                        listOf(
                                            viewModel.getRGBColor(97, 113, 238),
                                            viewModel.getRGBColor(180, 39, 240)
                                        ),
                                        start = androidx.compose.ui.geometry.Offset(0f, 0f),
                                        end = androidx.compose.ui.geometry.Offset.Infinite
                                    )
                                )
                                .padding(6.dp)
                                .clickable {
                                    if (isSelected) {
                                        selectedItems.remove(item)
                                    } else {
                                        selectedItems.add(item)
                                    }
                                }
                        ) {
                            Row (modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    "${selectedDirectionsPriorities[selectedDirections.indexOf(item)]}.",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .padding(start = 6.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = item,
                                    color = Color.White,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .align(alignment = Alignment.TopEnd)
                                    .clip(shape = CircleShape)
                                    .size(18.dp)
                                    .background(color = if (isSelected) viewModel.getRGBColor(97, 113, 238) else viewModel.getRGBColor(198, 198, 198), shape = CircleShape)
                            )
                        }
                    }
                }
            }

            val context = LocalContext.current

            var showDialog by remember { mutableStateOf(false) }

            Button(
                onClick = {
                    showDialog = true
                    //Toast.makeText(context, "Упс! Эта кнопка ещё не работает.", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = 60.dp, start = 10.dp, end = 10.dp)
            ) {
                Text("Удалить")
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text(text = "Удаление специальности") },
                    text = { Text("Вы уверены, что хотите удалить выбранные специальности?") },
                    confirmButton = {
                        Button(
                            onClick = {
                                showDialog = false

                                selectedItems.forEach{ index ->
                                    viewModel.deleteDirection(index)
                                }

                                navController.popBackStack()
                                Toast.makeText(context, "Специальности успешно были убраны", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Text("Да")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { showDialog = false }
                        ) {
                            Text("Отмена")
                        }
                    }
                )
            }
        }
    }
}