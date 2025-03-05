package com.example.sfeduhelper.view.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun AdmissionScreen(navController: NavController, viewModel: UserViewModel) {
    Image(
        painter = painterResource(R.drawable.main_background),
        contentDescription = ""
    )

    //TODO: добавить эти линии
    /*Image(
        painter = painterResource(R.drawable.linesAdmission),
        contentDescription = ""
    )*/

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //Заголовок
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Text(
                text = "Поступление",
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 5.dp)
                    .align(Alignment.BottomStart)
            )
        }

        Box {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp) // Высота области тени
                    .align(Alignment.BottomCenter) // Размещаем внизу
            ) {
                // Рисуем градиентную тень
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.2f), // Нижняя часть тени (полупрозрачная)
                            Color.Transparent // Верхняя часть тени (прозрачная)
                        ),
                        startY = 0f,
                        endY = size.height
                    ),
                    topLeft = Offset(0f, 0f),
                    size = size
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp)
        ) {
            val ButtonList: List<Pair<String, String>> = listOf(
                "Правила приёма" to "RulesAdmission",
                "Выбор направления" to "ChooseDirection",
                "Документы" to "Documents",
                "Индивидуальные достижения" to "IndividualAchievements",
                "Вступительные испытания" to "EntranceTests",
                "Сроки подачи документов" to "DeadlineDocuments"
            )
            var i = 0
            ButtonList.forEach{ (title, link) ->
                Button(
                    onClick = {
                        navController.navigate(route = link)
                    },
                    modifier = Modifier
                        .align(if (i % 2 == 0) Alignment.End else Alignment.Start)
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    viewModel.getRGBColor(97, 113, 238),
                                    viewModel.getRGBColor(180, 39, 240)
                                ),
                                start = androidx.compose.ui.geometry.Offset(0f, 0f),
                                end = androidx.compose.ui.geometry.Offset.Infinite
                            ),
                            shape = RoundedCornerShape(36.dp)
                        )
                        .clip(RoundedCornerShape(36.dp))
                        .fillMaxWidth(0.6f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    )
                ) { Text(
                    text = title,
                    textAlign = TextAlign.Center
                )
                }
                i++
            }
        }
        }
    }
