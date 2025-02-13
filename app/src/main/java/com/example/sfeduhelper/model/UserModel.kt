package com.example.sfeduhelper.model

import com.example.sfeduhelper.classes.StudyDirection
import com.example.sfeduhelper.classes.User

class UserModel {
    private var user: User = User("")
    private var directions: MutableList<StudyDirection> = mutableListOf()
    private var allDirections: MutableList<StudyDirection> = mutableListOf()

    fun getUser(): User {
        return user
    }

    fun saveUser(name: String) {
        user = User(name)
    }

    fun setDirections() {
        //здесь с сервера будут подгружаться все направления
        for (i in 1..9){
            allDirections.add(
                StudyDirection(
                    codeDirection = "0$i.0$i.0$i",
                    nameDirection = "Направление $i"
                )
            )
        }
    }

    fun getSelectedCodeDirections(): List<String>{
        var CodeDirections: MutableList<String> = mutableListOf()
        directions.forEach {
                direction -> CodeDirections.add(direction.codeDirection)
        }
        return CodeDirections
    }

    fun getAllCodeDirections(): List<String>{
        var CodeDirections: MutableList<String> = mutableListOf()
        allDirections.forEach {
            direction -> CodeDirections.add(direction.codeDirection)
        }
        return CodeDirections
    }

    fun getSelectedNameDirections(): List<String>{
        var NameDirections: MutableList<String> = mutableListOf()
        directions.forEach {
                direction -> NameDirections.add(direction.nameDirection)
        }
        return NameDirections
    }

    fun getAllNameDirections(): List<String>{
        var NameDirections: MutableList<String> = mutableListOf()
        allDirections.forEach {
                direction -> NameDirections.add(direction.nameDirection)
        }
        return NameDirections
    }
    fun AddDirection(codeDirection: String, levelPriority: Int){
        var newDirection: StudyDirection? = allDirections.find{ x: StudyDirection -> x.codeDirection == codeDirection}
        if (newDirection != null) {
            newDirection.levelPriority = levelPriority
            directions.add(newDirection)
        }

        sortDirections()
    }

    fun sortDirections(){
        directions.sortBy {it.levelPriority}
    }
    //здесь должны быть фактические функции работы с данными
}