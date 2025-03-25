package com.example.sfeduhelper.model

import com.example.sfeduhelper.classes.Link

class LinksModel {
    private var links: MutableList<Link> = mutableListOf()

    fun setLinks() {
        //TODO: Добавить подгрузку с сервера
    }

    fun setLinksExample() {
        for (i in 1..5){
            links.add(
                Link(
                    title = "Title $i",
                    desc = "Desc $i",
                    dateAdded = "2021.10.10"
                )
            )
        }
    }

    fun getLinks(): MutableList<Link> {
        if (links.isEmpty()) {
            setLinks()
        }
        return links
    }
}