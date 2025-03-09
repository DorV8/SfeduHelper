package com.example.sfeduhelper.classes

public class StudyDirection (var structDivision: String, var codeDirection: String, var nameDirection: String, var levelPriority: Int, var nameSpecialty: String) {
    constructor(structDivision: String, codeDirection: String, nameDirection: String, nameSpecialty: String) : this(structDivision, codeDirection, nameDirection, -1, nameSpecialty){
    }

    constructor(codeDirection: String, nameDirection: String, nameSpecialty: String) : this("", codeDirection, nameDirection, -1, nameSpecialty){}
    constructor() : this(structDivision = "", codeDirection = "", nameDirection = "", levelPriority = -1, nameSpecialty = "")

    //количество бюджетных мест
    var numberSeats: Int = -1

    //средний балл за прошлый год
    var avrScore: Int = -1

    //проходной балл за прошлый год
    var passingScore: Int = -1

    //цена обучения за год
    private var priceYear = 0

    //Форма обучения: очная (true) или заочная (false)
    private var isFullTimeForm: Boolean = true

    //Уровень обучения: бакалавриат (1), специалитет (2), аспирантура (3) и магистратура (4)
    private var levelStudy: Int = 1

    var Exams: MutableList<Exam> = mutableListOf()

    fun AddExam(nameExam: String){
        Exams.add(
            Exam(nameExam)
        )
    }

    fun AddExamWithScore(nameExam: String, passScore: Int){
        Exams.add(
            Exam(nameExam, passScore)
        )
    }

    fun getForm(): String {
        return if (isFullTimeForm)
            "Очная"
        else
            "Заочная"
    }

    fun setForm(isFullTime: Boolean) {
        isFullTimeForm = isFullTime
    }

    fun getLevelStudy(): String {
        var res = ""
        when (levelStudy) {
            1 -> res = "Бакалавриат"
            2 -> res = "Специалитет"
            3 -> res = "Аспирантура"
            4 -> res = "Магистратура"
        }
        return res
    }

    fun setLevelStudy(level: Int) {
        levelStudy = level
    }

    fun getPrice(): Int {
        return 0
    }

    fun setPrice(price: Int) {
        priceYear = price
    }
}