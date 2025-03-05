package com.example.sfeduhelper.view.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdmissionExtraInfoScreen(title: String, desc: String) {
    Column {
        Box (
            modifier = Modifier.height(100.dp)
        ) {
            Text(
                text = title,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 5.dp)
                    .align(Alignment.BottomStart)
                    .width(300.dp)
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
                            Color.Black.copy(alpha = 0.2f),
                            Color.Transparent
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
            text = desc,
            textAlign = TextAlign.Justify
        )
    }
}