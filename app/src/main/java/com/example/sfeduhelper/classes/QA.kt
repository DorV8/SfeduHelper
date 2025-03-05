package com.example.sfeduhelper.classes

class QA (id: Int = -1, question: String, answer: String) {

    constructor(): this(id = -1, question = "", answer = "")

    constructor(question: String, answer: String): this(id = -1, question, answer)
    var id: Int = id

    var question = question
    var answer = answer
}