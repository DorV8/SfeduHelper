package com.example.sfeduhelper.view.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun InfoInstitute(nameInstitute: String, viewModel: UserViewModel) {
    Column (
        modifier = Modifier.padding(top = 30.dp)
    ) {
        Row{
            Image(
                painter = painterResource(R.drawable.ictis_icon),
                modifier = Modifier
                    .size(75.dp)
                    .align(Alignment.CenterVertically),
                contentDescription = ""
            )
            Text(
                text = viewModel.getInfoInstitute(nameInstitute),
                modifier = Modifier
                    .width(400.dp)
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

        Image(
            painter = painterResource(R.drawable.ictis_photo),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
        )

        Text(
            text = "Информация об институте"
        )
    }
}