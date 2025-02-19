@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.sfeduhelper.view.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.contentValuesOf
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun AddSpecialtyPage(navController: NavController, viewModel: UserViewModel) {

    val context = LocalContext.current
    val background = painterResource(R.drawable.main_background)

    Image(
        painter = background,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )

    Box {
        var expandedStruct by remember { mutableStateOf(false) }
        var selectedOptionStruct by remember { mutableStateOf("") }
        val optionsSctruct = listOf("Опция 1", "Опция 2", "Опция 3", "Опция 4")

        var expandedCode by remember { mutableStateOf(false) }
        var selectedOptionCode by remember { mutableStateOf("") }
        var optionsCode by remember { mutableStateOf(viewModel.getAllCodeDirections()) }//listOf("Опция 1", "Опция 2", "Опция 3", "Опция 4")

        var priorityLevel by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Header()
            Text(
                text = "Структурное подразделение:",
                modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 10.dp)
            )
            ExposedDropdownMenuBox(
                expanded = expandedStruct,
                onExpandedChange = { expandedStruct = !expandedStruct },
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .background(color = Color.Transparent, shape = RoundedCornerShape(24.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 3.dp,
                            color = viewModel.getRGBColor(97, 113, 238), // Цвет границы
                            shape = RoundedCornerShape(24.dp) // Закруглённые углы
                        )
                        .clip(RoundedCornerShape(24.dp))
                ) {
                    TextField(
                        value = selectedOptionStruct,
                        onValueChange = {
                            optionsCode = viewModel.selectCodeDirectionsBySctruct(selectedOptionStruct)
                            optionsCode.forEach {
                                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
                            }
                        },
                        readOnly = true,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedStruct)
                        },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                        )
                    )
                }

                ExposedDropdownMenu(
                    expanded = expandedStruct,
                    onDismissRequest = { expandedStruct = false },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .clip(RoundedCornerShape(24.dp))
                ) {
                    optionsSctruct.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(text = option) },
                                onClick = {
                                    selectedOptionStruct = option
                                    expandedStruct = false

                                    optionsCode = viewModel.selectCodeDirectionsBySctruct(selectedOptionStruct)
                                    selectedOptionCode = ""
                                },
                                modifier = Modifier
                                    .height(40.dp)
                                    .fillMaxWidth()
                            )
                    }
                }
            }

            Text(
                text = "Код специальности:",
                modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 10.dp)
            )

            ExposedDropdownMenuBox(
                expanded = expandedCode,
                onExpandedChange = { expandedCode = !expandedCode },
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 3.dp,
                            color = viewModel.getRGBColor(97, 113, 238), // Цвет границы
                            shape = RoundedCornerShape(24.dp) // Закруглённые углы
                        )
                        .clip(RoundedCornerShape(24.dp))
                ) {
                    TextField(
                        value = selectedOptionCode,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedCode)
                        },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                        )
                    )
                }

                ExposedDropdownMenu(
                    expanded = expandedCode,
                    onDismissRequest = { expandedCode = false }
                ) {
                    optionsCode.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(text = option) },
                            onClick = {
                                selectedOptionCode = option
                                expandedCode = false
                            }
                        )
                    }
                }
            }

            Text(
                text = "Приоритет:",
                modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 10.dp)
            )
            OutlinedTextField(
                value = priorityLevel,
                onValueChange = { priorityLevel = it },
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
                    .fillMaxWidth()
                    .border(3.dp, viewModel.getRGBColor(97, 113, 238), RoundedCornerShape(24.dp))
                    .clip(RoundedCornerShape(24.dp)),
                shape = RoundedCornerShape(24.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = viewModel.getRGBColor(97, 113, 238),
                    unfocusedBorderColor = viewModel.getRGBColor(97, 113, 238)
                ),
            )

            if (viewModel.getSelectedCodeDirections().isEmpty()) {
                Text(
                    text = "Другие специальности и структурные подразделения можно добавить позднее, а указывать стоит приоритетную",
                    textAlign = TextAlign.Center
                )
                TextButton(
                    onClick = { navController.navigate("ProfilePage") },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Пропустить этот шаг")
                }
            }
        }
        Button(
            onClick = {
                clickReady(navController, viewModel, selectedOptionCode, priorityLevel, context)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)//.align(alignment = Alignment.BottomCenter) // Выравнивание по центру внизу
                .fillMaxWidth()
                .padding(bottom = 60.dp, start = 10.dp, end = 10.dp),
            shape = RoundedCornerShape(12.dp), // Скруглённые углы
            colors = ButtonDefaults.buttonColors(
                containerColor = viewModel.getRGBColor(143, 74, 234), // Фиолетовый фон
                contentColor = Color.White // Белый текст
            )
        ) {
            Text(
                text = "Готово",
                fontWeight = FontWeight.Bold // Полужирный текст
            )
        }
    }
}

@Composable
fun Header(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Настройка профиля",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 40.dp)
        )
    }
}

fun clickReady(navController: NavController, viewModel: UserViewModel, selectedOptionCode: String, priorityLevel: String, context: Context){

    if (selectedOptionCode.isNotEmpty() || selectedOptionCode.isNotBlank())
    {
        if (viewModel.getSelectedCodeDirections().contains(selectedOptionCode)) {
            Toast.makeText(context, "Данная специальность уже была выбрана, для редактирования необходимо удалить специальность и добавить снова.", Toast.LENGTH_LONG).show()
        }
        else {
                var priority: Int

                if (priorityLevel.isEmpty()) {
                    Toast.makeText(context, "Введите уровень приоритета (от 1 до 3)", Toast.LENGTH_LONG).show()
                }
                else
                    try {
                        priority = priorityLevel.toInt()

                        var priorityChanged = false
                        if (priority > 3){
                            priority = 3
                            priorityChanged = true
                        }
                        else if (priority < 1) {
                            priority = 1
                            priorityChanged = true
                        }

                        if (viewModel.getPriorities().contains(priority)) {
                            Toast.makeText(context, "Уже была выбрана специальность с таким приоритетом", Toast.LENGTH_LONG).show()
                        }
                        else {
                            viewModel.addDirectionToUser(selectedOptionCode, priority)
                            navController.navigate("ProfilePage")

                            if (priorityChanged) {
                                Toast.makeText(context, "Введённый уровень приоритета был округлён к ближайшему допустимому значению", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    catch (exception: Exception){
                        Toast.makeText(context, "Упс! Кажется вы ввели некорректные данные.", Toast.LENGTH_LONG).show()
                    }
        }
    }
    else {
        Toast.makeText(context, "Введите все нужные данные", Toast.LENGTH_LONG).show()
    }
}