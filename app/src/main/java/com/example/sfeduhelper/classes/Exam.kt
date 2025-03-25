package com.example.sfeduhelper.classes

import com.example.sfeduhelper.R

class Exam (var nameExam: String, var passScore: Int, var iconId: Int) {

    constructor(nameExam: String): this (nameExam, -1, R.drawable.sfedu_icon)

    constructor(nameExam: String, passScore: Int): this (nameExam, passScore, R.drawable.sfedu_icon)

    fun setIcon(iconId: Int) {
        this.iconId = iconId
    }
}