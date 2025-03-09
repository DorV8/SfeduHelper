package com.example.sfeduhelper.view.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun SpecialtyInfoScreen(viewModel: UserViewModel) {
    var direction = viewModel.getSelectedDirection()

    Box{
        Column (
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
            ) {
                Text(
                    text = direction.codeDirection,
                    modifier = Modifier
                        .width(400.dp)
                        .padding(start = 15.dp, top = 5.dp),
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
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

            Box {
                Column(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp)
                        .align(Alignment.TopCenter)
                ) {
                    val levelColor = viewModel.getRGBAColor(143, 74, 234, (0.75 * 255).toInt())

                    Text(
                        text = direction.nameDirection
                    )
                    Text(
                        text = "(${direction.nameSpecialty})",
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )

                    Row{
                        Surface(
                            shape = RoundedCornerShape(24.dp),
                            color = levelColor
                        ) {
                            Box(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(
                                    text = direction.getLevelStudy(),
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Surface(
                            shape = RoundedCornerShape(24.dp),
                            color = levelColor
                        ) {
                            Box(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(
                                    text = direction.getForm(),
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }

                    Text(
                        "Количество бюджетных мест: " + direction.numberSeats,
                        //modifier = Modifier.padding(10.dp)
                    )
                    Text(
                        "Стоимость обучения: " + direction.getPrice(),
                        //modifier = Modifier.padding(10.dp)
                    )

                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            /*.border(2.dp, color = Color.Red, shape = RectangleShape)*/
                    ){
                        Canvas(modifier = Modifier.matchParentSize()) {
                            val pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 10f), 0f)
                            drawRect(
                                color = viewModel.getRGBColor(125, 45, 230),
                                style = Stroke(
                                    width = 4f,
                                    pathEffect = pathEffect
                                ),
                                size = size
                            )
                        }

                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                            ) {
                                Text(
                                    text = "Минимальные баллы по ЕГЭ:",
                                    modifier = Modifier.fillMaxWidth(0.5f),
                                    textAlign = TextAlign.Left
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(2.dp)
                                        .background(Color.Red)
                                )
                                Text(
                                    text = "Минимальные баллы для СПО:",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Left
                                )
                            }

                            Canvas(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(4.dp)
                            ) {
                                val pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 10f), 0f)
                                drawLine(
                                    color = viewModel.getRGBColor(125, 45, 230),
                                    start = Offset(0f, 0f),
                                    end = Offset(size.width, 0f),
                                    strokeWidth = 2f,
                                    pathEffect = pathEffect
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                            ) {
                                Text(
                                    text = "Русский язык: 50\nМатематика: 50\nИнформатика: 50",
                                    modifier = Modifier.fillMaxWidth(0.5f),
                                    textAlign = TextAlign.Left
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(2.dp)
                                        .background(Color.Red)
                                )
                                Text(
                                    text = "Русский язык: 50\nМатематика: 50\nОчень длинное название: 50",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Left
                                )
                            }
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp, start = 15.dp, end = 15.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                viewModel.getRGBColor(18, 39, 195),
                                viewModel.getRGBColor(15, 103, 235)
                            ),
                            start = androidx.compose.ui.geometry.Offset(0f, 0f),
                            end = androidx.compose.ui.geometry.Offset.Infinite
                        ),
                        shape = RoundedCornerShape(24.dp)
                    )
                    //.clip(RoundedCornerShape(24.dp))
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .clickable {
                        //TODO: добавить переход на ссылку скачивания буклета
                    }
            ){
                Text(
                    "Скачать буклет",
                    color = Color.White,
                    modifier = Modifier
                        .padding(7.dp)
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = viewModel.getRGBColor(97, 113, 238),
                        shape = RoundedCornerShape(24.dp)
                    )
                    .background(color = viewModel.getRGBColor(247, 249, 251), shape = RoundedCornerShape(24.dp))
                    .clip(RoundedCornerShape(24.dp))
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .clickable {
                        //TODO: что-то должно открываться
                    }
            ){
                Text(
                    "Открыть",
                    color = viewModel.getRGBColor(97, 113, 238),
                    modifier = Modifier
                        .padding(7.dp)
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
