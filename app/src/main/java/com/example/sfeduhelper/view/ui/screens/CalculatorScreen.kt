package com.example.sfeduhelper.view.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.classes.Exam
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun CalculatorScreen(navController: NavController, viewModel: UserViewModel) {

    Column {
        //Заголовок
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.header),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
            )
            Text(
                text = "Калькулятор поступления",
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.BottomStart)
            )
        }
        Box {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp) // Высота области тени
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

        Text(
            text = "Выберите предметы, по которым вы сдавали ЕГЭ/вступительные испытания?",
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(30.dp))



        Column {
            viewModel.getAllExams().forEach{ item ->
                ExamCard(
                    R.drawable.sfedu_icon, //TODO: ВРЕМЕННО, ИСПРАВИТЬ
                    titleExam = item.nameExam,
                    viewModel
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Далее ->",
            textAlign = TextAlign.Right,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .clickable {
                    navController.navigate("CalculatedSpecialtiesScreen")
                }
                .align(Alignment.End)
        )
    }
}

@Composable
fun ExamCard(
    @DrawableRes imageRes: Int,
    titleExam: String,
    viewModel: UserViewModel
) {
    var examChosen by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = 5.dp,
                bottom = 5.dp
            )
            .border(
                width = 2.dp,
                color = viewModel.getRGBColor(97, 113, 238),
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Изображение
            Image(
                painter = painterResource(imageRes),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
            )

            // Текст
            Text(
                text = titleExam,
                textAlign = TextAlign.Left,
                modifier = Modifier.weight(1f)
            )

            // Кружок для выбора
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(
                        color = if (examChosen) viewModel.getRGBColor(97, 113, 238)
                        else viewModel.getRGBColor(198, 198, 198),
                        shape = CircleShape
                    )
                    .border(
                        width = 2.dp,
                        color = if (examChosen) viewModel.getRGBColor(97, 113, 238)
                        else viewModel.getRGBColor(198, 198, 198),
                        shape = CircleShape
                    )
                    .clickable {
                        examChosen = !examChosen
                        if (examChosen) {
                            viewModel.addExam(titleExam)
                        }
                        else {
                            viewModel.removeExam(titleExam)
                        }
                    }
            )
        }
    }
}