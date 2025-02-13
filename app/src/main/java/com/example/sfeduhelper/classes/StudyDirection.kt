package com.example.sfeduhelper.classes

class StudyDirection (var codeDirection: String, var nameDirection: String, var levelPriority: Int) {
    constructor(codeDirection: String, nameDirection: String) : this(codeDirection, nameDirection, -1){
    }
}