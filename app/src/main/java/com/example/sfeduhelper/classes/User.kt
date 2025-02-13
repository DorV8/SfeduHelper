package com.example.sfeduhelper.classes

class User (val name: String){
    var firstName: String = ""
    var lastName: String = ""
    var directions: MutableList<StudyDirection> = mutableListOf()
}
