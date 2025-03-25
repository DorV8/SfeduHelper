package com.example.sfeduhelper.view.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import com.example.sfeduhelper.classes.StudyDirection
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun CalculatedSpecialtiesScreen(navController: NavController, viewModel: UserViewModel){
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
                text = "Доступные специальности",
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

        Column (
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            viewModel.calculateSpecialties().forEach {x ->
                SpecialtyCard(x, viewModel.getRGBAColor(143, 74, 234, (0.75*255).toInt()))
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun SpecialtyCard(
    specialty: StudyDirection,
    borderColor: Color
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(24.dp))
            .border(2.dp, shape = RoundedCornerShape(24.dp), color = borderColor)
    ){
        Column (
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "${specialty.codeDirection} ${specialty.nameSpecialty}",
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text("Количество бюджетных мест: ${specialty.numberSeats}")
            Text("Конкурс на место: ")
            Text("Средний балл за прошлый год: ${specialty.avrScore}")
            Text("Проходной балл за прошлый год: ${specialty.passingScore}")

            Spacer(modifier = Modifier.height(10.dp))

            Text("Дата обновления: дд.мм.гг")
            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 10.dp)
            ) {
                Text("Открыть")
            }
        }
    }
}