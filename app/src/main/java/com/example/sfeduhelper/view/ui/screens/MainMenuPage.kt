package com.example.sfeduhelper.view.ui.screens

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun MainMenuPage(navController: NavController, viewModel: UserViewModel){

    Box () {
        Column(
            modifier = Modifier.padding(20.dp)
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

            /*//Поступление
            Box (
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(R.drawable.admission),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable(
                            onClick = {navController.navigate("AdmissionPage")}
                        )
                        .fillMaxWidth()
                        .height(250.dp)
                        .border(2.dp, color = viewModel.getRGBColor(97, 113, 238), shape = RoundedCornerShape(24.dp))
                )

                Button(
                    onClick = {navController.navigate("AdmissionPage")},
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(bottom = 30.dp)
                ) {
                    Text("Поступление")
                }
            }*/
        }
        //вот здесь будет маленькая кнопочка для сроков
    }
}