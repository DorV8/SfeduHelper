package com.example.sfeduhelper.model

import com.example.sfeduhelper.classes.StudyDirection
import kotlin.random.Random

class DirectionsModel {
    private var allDirections: MutableList<StudyDirection> = mutableListOf()
    private var selectedDirection: StudyDirection = StudyDirection()

    fun setDirections() {
        //здесь с сервера будут подгружаться все направления
        //TODO: добавить функцию подгрузки направлений с сервера
        for (i in 1..9){
            allDirections.add(
                StudyDirection(
                    codeDirection = "0$i.0$i.0$i",
                    nameDirection = "Направление $i",
                    structDivision = "Опция " + Random.nextInt(4),
                    nameSpecialty = "Специальность $i"
                )
            )
        }
    }

    fun getAllCodeDirections(): List<String>{
        var CodeDirections: MutableList<String> = mutableListOf()
        allDirections.forEach {
                direction -> CodeDirections.add(direction.codeDirection)
        }
        return CodeDirections
    }

    fun getAllNameDirections(): List<String>{
        var NameDirections: MutableList<String> = mutableListOf()
        allDirections.forEach {
                direction -> NameDirections.add(direction.nameDirection)
        }
        return NameDirections
    }


    fun selectCodeDirectionsBySctruct(nameStruct: String): List<String>{
        var CodeDirections: MutableList<String> = mutableListOf()
        allDirections.forEach {
                direction -> if (direction.structDivision == nameStruct) { CodeDirections.add(direction.codeDirection)}
        }
        return CodeDirections
    }

    fun findDirection(codeDirection: String): StudyDirection? {
        val newDirection: StudyDirection? = allDirections.find{ x: StudyDirection -> x.codeDirection == codeDirection}
        return newDirection
    }

    fun getAllDirections(): MutableList<StudyDirection> {
        return allDirections
    }

    fun setSelectedDirection(direction: StudyDirection) {
        selectedDirection = direction
    }

    fun getSelectedDirection(): StudyDirection {
        return selectedDirection
    }

}