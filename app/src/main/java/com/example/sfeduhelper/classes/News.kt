package com.example.sfeduhelper.classes

import android.graphics.drawable.Icon

class News (
    val sourceIcon: Int, // Resource ID для иконки источника
    val sourceName: String,
    val tags: List<String>,
    val title: String,
    val link: String
) {

}