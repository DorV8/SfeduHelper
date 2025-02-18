package com.example.sfeduhelper.classes

public class StudyDirection (var structDivision: String, var codeDirection: String, var nameDirection: String, var levelPriority: Int) {
    constructor(structDivision: String, codeDirection: String, nameDirection: String) : this(structDivision, codeDirection, nameDirection, -1){
    }

    constructor(codeDirection: String, nameDirection: String) : this("", codeDirection, nameDirection, -1){}

    //количество бюджетных мест
    var numberSeats: Int = -1

    //средний балл за прошлый год
    var avrScore: Int = -1

    //проходной балл за прошлый год
    var passingScore: Int = -1

    var Exams: MutableList<Exam> = mutableListOf()

    fun AddExam(nameExam: String){
        Exams.add(Exam(nameExam))
    }

    fun AddExamWithScore(nameExam: String, passScore: Int){
        Exams.add(Exam(nameExam, passScore))
    }
}