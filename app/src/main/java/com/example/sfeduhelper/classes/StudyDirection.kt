package com.example.sfeduhelper.classes

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Specialty")
public class StudyDirection /*(var structDivision: String, var codeDirection: String, var nameDirection: String, var levelPriority: Int, var nameSpecialty: String)*/ {

    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "code_specialty")
    var codeDirection: String = ""

    @ColumnInfo(name = "name_specialty")
    var nameSpecialty: String = ""

    @ColumnInfo(name = "id_form")
    var idForm: Int = -1

    @ColumnInfo(name = "id_division")
    var idDivision: Int = -1

    @ColumnInfo(name = "id_level")
    var idLevel: Int = -1

    @ColumnInfo(name = "number_budget_seats")
    var numberBudgetSeats: Int = -1

    @ColumnInfo(name = "number_paid_seats")
    var numberPaidSeats: Int = -1

    @ColumnInfo(name = "price_year")
    var priceYear: Int = 0

    @ColumnInfo(name = "realisation_place")
    var place: String = "Таганрог"

    @ColumnInfo(name = "average_score")
    var averageScore: Int = 0

    @ColumnInfo(name = "passing_score")
    var passingScore: Int = 0

    constructor(codeDirection: String, nameSpecialty: String) {
        this.codeDirection = codeDirection
        this.nameSpecialty = nameSpecialty
    }

    constructor() {}

    fun isFullTime(): Boolean {
        return (idForm == 1)
    }

    var Exams: MutableList<Exam> = mutableListOf()

    fun AddExam(nameExam: String){
        Exams.add(
            Exam(nameExam)
        )
    }

    fun getForm(): String {
        //TODO: заменить на запрос к БД
        return if (isFullTime())
            "Очная"
        else
            "Заочная"
    }

    fun setForm(isFullTime: Boolean) {
        //TODO
    }

    fun getLevelStudy(): String {
        //TODO
        var res = ""
        when (idLevel) {
            1 -> res = "Бакалавриат"
            2 -> res = "Специалитет"
            3 -> res = "Аспирантура"
            4 -> res = "Магистратура"
        }
        return res
    }

    fun setLevelStudy(level: Int) {
        //TODO
        idLevel = level
    }

    fun getPrice(): Int {
        //TODO
        return 0
    }

    fun setPrice(price: Int) {
        //TODO
        priceYear = price
    }
}