package com.example.sfeduhelper.view.ui.screens

import android.graphics.PathEffect
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun SpecialtyAndDirectionsScreen(navController: NavController, viewModel: UserViewModel) {
    Column {
        Spacer(modifier = Modifier.height(25.dp))
        Row{
            Text(
                text = "Специальности и направления подготовки",
                modifier = Modifier
                    .width(400.dp)
                    .padding(start = 15.dp, top = 5.dp),
                textAlign = TextAlign.Left
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

        //____________________________________________//

        Column (
            modifier = Modifier.verticalScroll(rememberScrollState())
                .padding(bottom = 50.dp)
        ) {
            var directions = viewModel.getAllDirections()

            directions.forEach{ direction ->
                Box (
                    modifier = Modifier.clickable {
                        viewModel.setSelectedDirection(direction)
                        navController.navigate("SpecialtyInfoScreen")
                    }
                ) {
                    SpecialtyCard(
                        direction.codeDirection,
                        direction.nameSpecialty,
                        direction.nameDirection,
                        direction.getForm(),
                        direction.getLevelStudy(),
                        direction.numberSeats,
                        direction.getPrice(),
                        borderColor = viewModel.getRGBColor(180, 39, 240),
                        levelColor = viewModel.getRGBAColor(143, 74, 234, (0.75 * 255).toInt())
                    )
                }
                Spacer (modifier = Modifier.height(5.dp))
            }
        }
    }
}

@Composable
fun SpecialtyCard(
    codeSpecialty: String,
    nameSpecialty: String,
    nameDirection: String,
    formStudy: String,
    levelStudy: String,
    numberSeats: Int,
    price: Int,
    borderColor: Color,
    levelColor: Color
) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(24.dp))
                .border(2.dp, shape = RoundedCornerShape(24.dp), color = borderColor)
        ){
            Row (
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = codeSpecialty,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = nameSpecialty
                )
            }
            Text(
                text = "($nameDirection)",
                modifier = Modifier.padding(10.dp))
            Row ( modifier = Modifier
                    .padding(10.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = levelColor
                ) {
                    Box(
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Text(
                            text = levelStudy,
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
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Text(
                            text = formStudy,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            Text ("Количество бюджетных мест: " + numberSeats, modifier = Modifier.padding(10.dp))
            Text("Стоимость обучения: " + price, modifier = Modifier.padding(10.dp))
        }
}