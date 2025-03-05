package com.example.sfeduhelper.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.res.painterResource
import com.example.sfeduhelper.classes.News

class NewsModel {

    private var NewsList: MutableList<News> = mutableListOf()

    fun addNews(sourceName: String, tags: List<String>, title: String, link: String ) {
        val sourceIcon = Icons.Default

        //добавить иконки и соответствующий выбор иконки
        /*when (sourceName) {
            "TG" -> sourceIcon = Icons.TG
            "VK" -> sourceIcon = Icons.VK
            "SITE" -> sourceIcon = Icons.Site
        }*/
        NewsList.add(
            News(sourceName = sourceName, tags = tags, title = title, link = link, sourceIcon = -1)
        )
    }

    fun getNews(): List<News> {
        return NewsList
    }
}