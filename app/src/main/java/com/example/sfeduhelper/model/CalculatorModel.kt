package com.example.sfeduhelper.model

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sfeduhelper.classes.Exam
import com.example.sfeduhelper.classes.StudyDirection

class CalculatorModel (directionsModel: DirectionsModel) {

    //Все существующие экзамены
    private var AllExams: MutableList<Exam> = mutableListOf()

    //Экзамены, выбранные в калькуляторе
    private var SelectedExams: MutableList<Exam> = mutableListOf()

    fun setExamsSample() {
        var listExam: List<String> = listOf("Русский язык","Математика (база)", "Математика (профиль)", "География", "Информатика")
        AllExams.clear()
        listExam.forEach{ exam ->
            AllExams.add(Exam(exam))
        }
    }

    fun getAllExams(): MutableList<Exam> {
        return AllExams
    }

    fun getAllExamsName(): MutableList<String> {
        var names: MutableList<String> = mutableListOf()

        AllExams.forEach{exam ->
            names.add(exam.nameExam)
        }

        return names
    }

    fun addExam(nameExam: String) {
        AllExams.find { x -> x.nameExam == nameExam }?.let { SelectedExams.add(it) }
    }

    fun removeExam(nameExam: String) {
        AllExams.find { x -> x.nameExam == nameExam }?.let { SelectedExams.remove(it) }
    }

    fun getSelectedExams(): MutableList<Exam> {
        return SelectedExams
    }
}