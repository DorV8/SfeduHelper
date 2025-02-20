package com.example.sfeduhelper.model

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
}