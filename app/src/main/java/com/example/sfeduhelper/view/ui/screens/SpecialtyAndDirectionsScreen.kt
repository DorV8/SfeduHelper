package com.example.sfeduhelper.view.ui.screens

import android.graphics.PathEffect
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
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
                    .width(400.dp),
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
                    //TODO: переход на полный просмотр этой специальности
                    //navController.navigate("")
                    }
                ) {
                    SpecialtyCard(
                        direction.codeDirection,
                        direction.nameSpecialty,
                        direction.nameDirection,
                        direction.getForm(),
                        direction.getLevelStudy(),
                        direction.numberSeats,
                        0,
                        viewModel.getRGBColor(180, 39, 240)
                    )
                }
                Spacer (modifier = Modifier.height(8.dp))
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
    borderColor: Color
) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(24.dp))
                .border(2.dp, shape = RoundedCornerShape(24.dp), color = borderColor)
        ){
            Row (
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(codeSpecialty)
                Spacer(modifier = Modifier.width(5.dp))
                Text(nameSpecialty)
            }
            Text(nameDirection, modifier = Modifier.padding(start = 10.dp))
            Row (
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(levelStudy)
                Spacer(modifier = Modifier.width(5.dp))
                Text(formStudy)
            }
            Text ("Количество бюджетных мест: " + numberSeats, modifier = Modifier.padding(start = 10.dp))
            Text("Стоимость обучения: " + price, modifier = Modifier.padding(start = 10.dp))
        }
}