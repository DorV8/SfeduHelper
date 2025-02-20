package com.example.sfeduhelper.model

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sfeduhelper.classes.Link
import com.example.sfeduhelper.classes.StudyDirection
import com.example.sfeduhelper.classes.User
import kotlin.random.Random

class UserModel {
    private var user: User = User("")

    //ЗАГОТОВКИ НА РАБОТУ С ДАННЫМИ ПОЛЬЗОВАТЕЛЯ
    fun getUser(): User {
        return user
    }

    fun saveUser(name: String) {
        user = User(name)
    }

    fun setAfter(after: String) {
        user.after = after
    }

    fun getAfter(): String {
        return user.after
    }

    //______________________________________________//

    private var directions: MutableList<StudyDirection> = mutableListOf()

    //ПОЛУЧЕНИЕ ВЫБРАННЫХ СПЕЦИАЛЬНОСТЕЙ И НАПРАВЛЕНИЙ

    fun getSelectedCodeDirections(): List<String>{
        var CodeDirections: MutableList<String> = mutableListOf()
        directions.forEach {
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

    fun getPriorities(): List<Int> {
        var priorities: MutableList<Int> = mutableListOf()
        directions.forEach { direction ->
            priorities.add(direction.levelPriority)
        }
        return priorities
    }

    //______________________________________________//

    //ДОБАВЛЕНИЕ, СОРТИРОВКА И УДАЛЕНИЕ НАПРАВЛЕНИЙ

    fun AddDirection(newDirection: StudyDirection?, levelPriority: Int){
        //var newDirection: StudyDirection? = allDirections.find{ x: StudyDirection -> x.codeDirection == codeDirection}
        if (newDirection != null) {
            newDirection.levelPriority = levelPriority
            directions.add(newDirection)
        }

        sortDirections()
    }

    fun sortDirections(){
        directions.sortBy {it.levelPriority}
    }

    fun DeleteDirection(codeDirection: String) {
        directions.remove(directions.find { x -> x.codeDirection == codeDirection })
    }
    //______________________________________________//
}