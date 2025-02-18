package com.example.sfeduhelper.classes

class User (val name: String){
    var firstName: String = name
    var lastName: String = ""
    var directions: MutableList<StudyDirection> = mutableListOf()

    var after: String = ""
}
