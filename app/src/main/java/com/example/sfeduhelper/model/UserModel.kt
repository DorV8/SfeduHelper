package com.example.sfeduhelper.model

import com.example.sfeduhelper.classes.Link
import com.example.sfeduhelper.classes.StudyDirection
import com.example.sfeduhelper.classes.User
import kotlin.random.Random

class UserModel {
    private var user: User = User("")

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


    private var directions: MutableList<StudyDirection> = mutableListOf()
    private var allDirections: MutableList<StudyDirection> = mutableListOf()

    fun setDirections() {
        //здесь с сервера будут подгружаться все направления
        for (i in 1..9){
            allDirections.add(
                StudyDirection(
                    codeDirection = "0$i.0$i.0$i",
                    nameDirection = "Направление $i",
                    structDivision = "Опция " + Random.nextInt(4)
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

    fun getPriorities(): List<Int> {
        var priorities: MutableList<Int> = mutableListOf()
        directions.forEach { direction ->
            priorities.add(direction.levelPriority)
        }
        return priorities
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

    fun DeleteDirection(codeDirection: String) {
        directions.remove(directions.find { x -> x.codeDirection == codeDirection })
    }

    fun selectCodeDirectionsBySctruct(nameStruct: String): List<String>{
        var CodeDirections: MutableList<String> = mutableListOf()
        allDirections.forEach {
            direction -> if (direction.structDivision == nameStruct) { CodeDirections.add(direction.codeDirection)}
        }
        return CodeDirections
    }

    fun sortDirections(){
        directions.sortBy {it.levelPriority}
    }

    private var links: MutableList<Link> = mutableListOf()

    fun setLinks() {
        for (i in 1..5){
            links.add(
                Link(
                    title = "Title $i",
                    desc = "Desc $i",
                    dateAdded = "2021.10.10"
                )
            )
        }
    }

    fun getLinks(): MutableList<Link> {
        if (links.isNullOrEmpty()) {
            setLinks()
        }
        return links
    }
    //здесь должны быть фактические функции работы с данными
}