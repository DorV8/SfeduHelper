package com.example.sfeduhelper.classes

class Link(title: String, tags: List<String>, desc: String, dateAdded: String, url: String) {

    constructor(title: String, desc: String, dateAdded: String): this(title, tags = listOf("1"), desc, dateAdded, url = "https://t.me/med1aemp1re")

    var title = title
    var tags = tags
    var desc = desc
    var dateAdded = dateAdded
    var url = url
}