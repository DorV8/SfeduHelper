package com.example.sfeduhelper.view.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsPage(navController: NavController, viewModel: UserViewModel){
    var selectedOptionNotifications by remember { mutableStateOf("") }
    var notificationsInApp by remember { mutableStateOf(false) }
    var notificationInTG by remember { mutableStateOf(false)}

    val background = painterResource(R.drawable.main_background)

    Image(
        painter = background,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                title = { Text("Настройки", fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ExpandableSettingItem(
                icon = Icons.Default.Notifications,
                title = "Уведомления",
                content = {
                    Text(
                        text = "Как привязать телеграм-ботов?",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer semper. fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Категории уведомлений:",
                        fontWeight = FontWeight.Bold
                    )
                    StateCard(
                        text = "Со звуком",
                        isSelected = selectedOptionNotifications == "Option1",
                        onClick = { selectedOptionNotifications = "Option1" },
                        viewModel
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Второе состояние
                    StateCard(
                        text = "Вибрация",
                        isSelected = selectedOptionNotifications == "Option2",
                        onClick = { selectedOptionNotifications = "Option2" },
                        viewModel
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Третье состояние
                    StateCard(
                        text = "Без звука",
                        isSelected = selectedOptionNotifications == "Option3",
                        onClick = { selectedOptionNotifications = "Option3" },
                        viewModel
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Способ получения уведомлений")

                    SwitchCard(
                        text = "В приложении",
                        isChecked = notificationsInApp,
                        onCheckedChange = { notificationsInApp = it},
                        viewModel
                    )

                    SwitchCard(
                        text = "В Телеграме",
                        isChecked = notificationInTG,
                        onCheckedChange = { notificationInTG = it},
                        viewModel
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            viewModel.updateCategoryNotification(selectedOptionNotifications)
                            viewModel.updateMethodsNotification(notificationInTG, notificationsInApp)
                        },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text("Сохранить")
                    }
                }
            )
            val questionsAndAnswers = viewModel.getFAQ()

            ExpandableSettingItem(
                icon = Icons.Default.Favorite,
                title = "FAQ",
                content = {
                    Column {
                        questionsAndAnswers.forEach{ (question, answer) ->
                            QuestionAnswerItem(question, answer, viewModel)
                        }
                    }
                }
            )
            ExpandableSettingItem(
                icon = Icons.Default.Info,
                title = "О приложении",
                content = {
                    Text("Версия ${viewModel.getVersion()}\nКоманда: Response:200\nРоадмап:")
                }
            )
        }
    }
}

@Composable
fun QuestionAnswerItem(question: String, answer: String, viewModel: UserViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Вопрос (выравнивание по левому краю)
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .background(
                    color = viewModel.getRGBAColor(
                        143,
                        74,
                        234,
                        alpha = (0.56 * 255).toInt()
                    ), // Светло-голубой цвет
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = question,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.TopStart)
            )
        }

        Spacer(modifier = Modifier.height(8.dp)) // Отступ между вопросом и ответом

        // Ответ (выравнивание по правому краю)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
                .background(
                    color = Color.White, // Светло-зелёный цвет
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = answer,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun ExpandableSettingItem(
    icon: ImageVector,
    title: String,
    content: @Composable () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .scrollable(
                ScrollableState { it },
                orientation = Orientation.Vertical
            ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.clickable { isExpanded = !isExpanded }
            ) {
                Box (
                    modifier = Modifier
                        .weight(1f)
                ){
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        modifier = Modifier.size(24.dp).align(Alignment.CenterStart)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = title, fontSize = 18.sp, modifier = Modifier.padding(start = 40.dp))
                }

                Box {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                    )
                }
            }
            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(
                    modifier = Modifier.padding(top = 8.dp),
                    
                ) {
                    content()
                }
            }
        }
    }
}

@Composable
fun SwitchCard(
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    viewModel: UserViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, viewModel.getRGBColor(97, 113, 238)),
        colors = CardDefaults.cardColors(
            containerColor = if (isChecked) viewModel.getRGBAColor(143, 74, 234, (0.56*255).toInt())
            else viewModel.getRGBColor(247, 249, 251)
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge
            )
            Switch(
                checked = isChecked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}

@Composable
fun StateCard(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    viewModel: UserViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = isSelected,
                onClick = onClick,
                role = Role.RadioButton
            ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, viewModel.getRGBColor(97, 113, 238)),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) viewModel.getRGBAColor(143, 74, 234, (0.56*255).toInt())
            else viewModel.getRGBColor(247, 249, 251)
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.width(100.dp)
            )
            Spacer(modifier = Modifier.width(160.dp))
            RadioButton(
                selected = isSelected,
                modifier = Modifier.fillMaxWidth(),
                onClick = null // Управляется родительским контейнером
            )
        }
    }
}