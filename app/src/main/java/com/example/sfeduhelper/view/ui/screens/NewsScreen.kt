package com.example.sfeduhelper.view.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sfeduhelper.R
import com.example.sfeduhelper.classes.News
import com.example.sfeduhelper.viewmodel.UserViewModel

@Composable

fun NewsScreen(navController: NavController, viewModel: UserViewModel) {
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
                text = "Новости",
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.BottomStart)
            )
        }

        val items = viewModel.getNews()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, bottom = 30.dp)
        ) {
            Column (
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                items.forEach {item ->
                    NewsCard(newsItem = item)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
fun NewsCard(newsItem: News) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                println("Clicked on: ${newsItem.title}")
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Источник и иконка
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.sfedu_icon), //TODO: Добавить ссылку на иконку на базе sourceName
                    contentDescription = "Source Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = newsItem.sourceName,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            // Теги
            Row(
                modifier = Modifier.padding(top = 4.dp)
            ) {
                newsItem.tags.forEach { tag ->
                    Chip(onClick = { /*TODO*/ }, label = tag)
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }

            // Заголовок
            Text(
                text = newsItem.title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 8.dp)
            )

            // Ссылка "Перейти"
            Text(
                text = "Перейти...",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable {
                        // TODO: Открытие ссылки (например, с помощью Intent)
                        println("Go to: ${newsItem.link}")
                    }
                    .align(Alignment.End)
            )
        }
    }
}

@Composable
fun Chip(
    onClick: () -> Unit,
    label: String
) {
    Surface(
        modifier = Modifier.height(32.dp),
        tonalElevation = 8.dp,
        shadowElevation = 8.dp,
        shape = MaterialTheme.shapes.extraSmall,
        color = MaterialTheme.colorScheme.surfaceVariant,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(label)
        }
    }
}

