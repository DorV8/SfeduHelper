package com.example.sfeduhelper.view.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: UserViewModel) {
    Box () {
        val context = LocalContext.current
        Column(
            modifier = Modifier.padding(20.dp).verticalScroll(rememberScrollState())
        ) {
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
                    text = "Главное меню",
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .align(Alignment.BottomStart)
                )
            }

            //ПОСТУПЛЕНИЕ

            Box(
                modifier = Modifier
                    .height(270.dp)
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                Box (
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(24.dp))
                        .clip(RoundedCornerShape(24.dp))
                        .border(
                            2.dp,
                            viewModel.getRGBColor(97, 113, 238),
                            shape = RoundedCornerShape(24.dp)
                        )
                ){
                    Image(
                        painter = painterResource(R.drawable.admission),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .graphicsLayer(
                                scaleX = 1.4f,
                                scaleY = 1.4f
                            )
                            .clickable {
                                navController.navigate("AdmissionScreen")
                            }
                    )
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.linearGradient(
                                    listOf(
                                        viewModel.getRGBColor(97, 113, 238),
                                        viewModel.getRGBColor(180, 39, 240)
                                    ),
                                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                                    end = androidx.compose.ui.geometry.Offset.Infinite)
                            )
                            .align(Alignment.BottomCenter)
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White
                            )
                        ) { Text("Поступление") }
                    }
                }
            }
            //_________________________________________________//

            //ИНФОРМАЦИЯ ОБ ИНСТИТУТЕ

            Box(
                modifier = Modifier
                    .height(270.dp)
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                Box (
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(24.dp))
                        .clip(RoundedCornerShape(24.dp))
                        .border(
                            2.dp,
                            viewModel.getRGBColor(97, 113, 238),
                            shape = RoundedCornerShape(24.dp)
                        )
                        .clickable {
                            //TODO: добавить выбор структурного подразделения
                            navController.navigate("InfoICTIS")
                        }
                ){
                    Image(
                        painter = painterResource(R.drawable.info_insitute),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .graphicsLayer(
                                scaleX = 1.4f,
                                scaleY = 1.4f
                            )
                            .clickable {
                                navController.navigate("InfoICTIS")
                            }
                    )
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.linearGradient(
                                    listOf(
                                        viewModel.getRGBColor(97, 113, 238),
                                        viewModel.getRGBColor(180, 39, 240)
                                    ),
                                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                                    end = androidx.compose.ui.geometry.Offset.Infinite)
                            )
                            .align(Alignment.BottomCenter)
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White
                            )
                        ) { Text("Информация об институте") }
                    }
                }
            }
            //________________________________________________________//

            //СПЕЦИАЛЬНОСТИ И НАПРАВЛЕНИЯ ПОДГОТОВКИ
            Box(
                modifier = Modifier
                    .height(270.dp)
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                Box (
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(24.dp))
                        .clip(RoundedCornerShape(24.dp))
                        .border(
                            2.dp,
                            viewModel.getRGBColor(97, 113, 238),
                            shape = RoundedCornerShape(24.dp)
                        )
                ){
                    Image(
                        painter = painterResource(R.drawable.directions),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .graphicsLayer(
                                scaleX = 1.4f,
                                scaleY = 1.4f
                            )
                            .clickable {
                                //navController.navigate("")
                                navController.navigate("SpecialtyAndDirectionsPage")
                            }
                    )
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.linearGradient(
                                    listOf(
                                        viewModel.getRGBColor(97, 113, 238),
                                        viewModel.getRGBColor(180, 39, 240)
                                    ),
                                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                                    end = androidx.compose.ui.geometry.Offset.Infinite)
                            )
                            .align(Alignment.BottomCenter)
                    ) {
                        Button(
                            onClick = {
                                navController.navigate("SpecialtyAndDirectionsPage")
                            },
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White
                            )
                        ) { Text("Специальности и направления подготовки") }
                    }
                }
            }
            //_____________________________________________________________//
            Spacer(modifier = Modifier.height(30.dp))
        }

        //_________________________________________________________________//

        //КНОПКА СРОКА ПРИЁМА ДОКУМЕНТОВ

        var showDialog by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                //.clip(RoundedCornerShape(topStart = 64.dp, bottomStart = 64.dp, topEnd = 0.dp, bottomEnd = 0.dp))
                .align(Alignment.TopEnd)
        ) {
            Button(
                onClick = {showDialog = true},
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(top = 140.dp)
                    .width(70.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 64.dp,
                            bottomStart = 64.dp,
                            topEnd = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
                    .offset(x = 30.dp)
            ){}
        }
        //___________________________________________________________________//

        //ОКНО СО СРОКАМИ

        if (showDialog) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 20.dp, end = 20.dp)
                    .background(Color.White, shape = RoundedCornerShape(24.dp))
            ) {
                Column (
                    modifier = Modifier
                        .border(
                            4.dp,
                            viewModel.getRGBColor(97, 113, 238),
                            shape = RoundedCornerShape(24.dp)
                        )
                        .background(Color.White, shape = RoundedCornerShape(24.dp))
                ) {
                    Image(
                        painter = painterResource(R.drawable.megaphone),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 30.dp, bottom = 15.dp)
                    )
                    Text(
                        text = "ВНИМАНИЕ!",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 10.dp)
                    )
                    Text(
                        text = "Срок приёма документов заканчивается дд.мм.гггг",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 40.dp)
                    )
                }
                Button(
                    onClick = {showDialog = false},
                    modifier = Modifier
                        .align(Alignment.TopEnd),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "X",
                        color = Color.Black
                    )
                }
            }
        }
        //__________________________________________________________//
    }
}