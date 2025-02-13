@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.sfeduhelper.view.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable
fun AddSpecialtyPage(navController: NavController, viewModel: UserViewModel) {

    val background = painterResource(R.drawable.background_sfedu)

    Image(
        painter = background,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Header()

        Text(
            text = "Код специальности:",
            modifier = Modifier.padding(start = 5.dp, top = 5.dp)
        )

        var expandedCode by remember { mutableStateOf(false) }
        var selectedOptionCode by remember { mutableStateOf("") }
        val optionsCode = viewModel.getAllCodeDirections()//listOf("Опция 1", "Опция 2", "Опция 3", "Опция 4")

        ExposedDropdownMenuBox(
            expanded = expandedCode,
            onExpandedChange = { expandedCode = !expandedCode },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            OutlinedTextField(
                value = selectedOptionCode,
                onValueChange = {},
                readOnly = true,
                label = { Text("Выберите специальность") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedCode)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

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
            text = "Структурное подразделение:",
            modifier = Modifier.padding(start = 5.dp, top = 5.dp)
        )

        var expandedStruct by remember { mutableStateOf(false) }
        var selectedOptionStruct by remember { mutableStateOf("") }
        val optionsSctruct = listOf("Опция 1", "Опция 2", "Опция 3", "Опция 4")

        ExposedDropdownMenuBox(
            expanded = expandedStruct,
            onExpandedChange = { expandedStruct = !expandedStruct },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            OutlinedTextField(
                value = selectedOptionStruct,
                onValueChange = {},
                readOnly = true,
                label = { Text("Выберите структурное подразделение") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedStruct)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expandedStruct,
                onDismissRequest = { expandedStruct = false }
            ) {
                optionsSctruct.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(text = option) },
                        onClick = {
                            selectedOptionStruct = option
                            expandedStruct = false
                        }
                    )
                }
            }
        }
        Text(
            text = "Приоритет:",
            modifier = Modifier.padding(start = 5.dp, top = 5.dp)
        )
        var priorityLevel by remember { mutableStateOf("") }
        TextField(
            value = priorityLevel,
            onValueChange = {priorityLevel = it},
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                clickReady(navController, viewModel, selectedOptionCode, priorityLevel)},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "ГОТОВО"
            )
        }
        if (viewModel.getSelectedCodeDirections().isNullOrEmpty()) {
            Text(
                text = "Другие специальности и структурные подразделения можно добавить позднее, а указывать стоит приоритетную",
                textAlign = TextAlign.Center
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

fun clickReady(navController: NavController, viewModel: UserViewModel, selectedOptionCode: String, priorityLevel: String){
    if (selectedOptionCode.isNotEmpty() || selectedOptionCode.isNotBlank())
    {
        var priority: Int
        try {
            priority = priorityLevel.toInt()
            if (priority > 3){
                priority = 3
            }
            else if (priority < 1) {
                priority = 1
            }
            viewModel.addDirectionToUser(selectedOptionCode, priority)
            navController.navigate("ProfilePage")
        }
        catch (exception: Exception){
            println("Ошибка")
        }
    }
}