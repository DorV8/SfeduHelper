package com.example.sfeduhelper.classes

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Study_form")
class FormStudy {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo (name = "id_form")
    var idForm: Int = -1

    @ColumnInfo (name = "name_form")
    var nameForm: String = ""
}