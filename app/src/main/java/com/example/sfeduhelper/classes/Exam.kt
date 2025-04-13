package com.example.sfeduhelper.classes

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sfeduhelper.R

@Entity(tableName = "Exams")
class Exam {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_exam")
    var id: Int = 0

    @ColumnInfo(name = "name_exam")
    var name: String? = null

    var iconId: Int = -1

    constructor() {}

    constructor(nameExam: String) {
        this.name = nameExam
        this.iconId = R.drawable.sfedu_icon
    }

    fun setIcon(iconId: Int) {
        this.iconId = iconId
    }
}