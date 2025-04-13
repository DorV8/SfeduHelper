package com.example.sfeduhelper.classes

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Levels")
class LevelStudy {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo (name = "id_level")
    var idLevel: Int = -1

    @ColumnInfo (name = "name_level")
    var nameLevel: String = ""
}