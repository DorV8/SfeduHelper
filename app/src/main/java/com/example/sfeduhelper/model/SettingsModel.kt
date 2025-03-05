package com.example.sfeduhelper.model

import com.example.sfeduhelper.classes.QA

class SettingsModel {

    //КАТЕГОРИИ УВЕДОМЛЕНИЙ

    private var CategoryNotifications: String = ""

    fun setCategory(){
        //здесь будет подтягиваться из памяти категория уведомлений
    }

    fun getCategory(): String {
        return CategoryNotifications
    }

    fun updateCategory(category: String) {
        CategoryNotifications = category
    }

    //______________________________________________//

    //СПОСОБЫ ПОЛУЧЕНИЯ УВЕДОМЛЕНИЙ

    private var methodsNotification: MutableList<String> = mutableListOf()

    fun setMethods(){
        //здесь будет подтягиваться метод уведомлений из памяти
    }

    fun getMethods(): MutableList<String>{
        return methodsNotification
    }

    fun updateMethods(notificationInTG: Boolean, notificationInApp: Boolean){
        methodsNotification.clear()
        if (notificationInTG) { methodsNotification.add("TG") }
        if (notificationInApp) { methodsNotification.add("App") }
    }

    //______________________________________________//

    //ВЕРСИЯ

    private var version: String = "0.0.3"

    fun setVersion(vers: String) {
        version = vers
    }

    fun getVersion(): String {
        return version
    }

    //______________________________________________//

    //ЧАСТЫЕ ВОПРОСЫ

    private var faq: MutableList<QA> = mutableListOf()

    fun getFAQ(): List<Pair<String, String>> {
        val pairList: List<Pair<String, String>> = faq.map { data ->
            Pair(data.question, data.answer)
        }
        return pairList
    }

    fun setFAQ() {
        val questions = List(10) { i -> "Вопрос ${i + 1}" }
        val answers = List(size = 10) {i -> "Ответ ${i + 1}"}

        for (i in 0..9) {
            faq.add(
                QA(questions[i], answers[i])
            )
        }
    }
}