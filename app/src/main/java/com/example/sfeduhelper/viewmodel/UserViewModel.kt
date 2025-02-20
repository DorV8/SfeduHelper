package com.example.sfeduhelper.viewmodel

import android.graphics.Path.Direction
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.sfeduhelper.classes.Link
import com.example.sfeduhelper.classes.User
import com.example.sfeduhelper.model.DirectionsModel
import com.example.sfeduhelper.model.LinksModel
import com.example.sfeduhelper.model.SettingsModel
import com.example.sfeduhelper.model.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel: ViewModel() {
    val userModel: UserModel = UserModel()

    //РАБОТА С UserModel

    fun addDirectionToUser(codeDirection: String, levelPriority: Int){
        userModel.AddDirection(directionsModel.findDirection(codeDirection), levelPriority)
    }

    fun getSelectedCodeDirections(): List<String>{
        return  userModel.getSelectedCodeDirections()
    }

    fun getSelectedNameDirections(): List<String> {
        return userModel.getSelectedNameDirections()
    }

    fun setAfter(after: String){
        userModel.setAfter(after)
    }

    fun getAfter() {
        userModel.getAfter()
    }

    fun getPriorities(): List<Int> {
        return userModel.getPriorities()
    }

    fun deleteDirection(codeDirection: String) {
        userModel.DeleteDirection(codeDirection)
    }
    //_________________________________________________//

    val directionsModel: DirectionsModel = DirectionsModel()

    //РАБОТА С DirectionsModel

    fun getAllCodeDirections(): List<String>{
        return directionsModel.getAllCodeDirections()
    }

    fun getAllNameDirections(): List<String> {
        return directionsModel.getAllNameDirections()
    }

    fun selectCodeDirectionsBySctruct(nameStruct: String): List<String>{
        return directionsModel.selectCodeDirectionsBySctruct(nameStruct)
    }

    fun setDirections() {
        directionsModel.setDirections()
    }
    //_________________________________________________//

    val linksModel: LinksModel = LinksModel()

    //РАБОТА С LinksModel

    fun setLinks() {
        linksModel.setLinks()
    }
    fun getLinks(): MutableList<Link> {
        return linksModel.getLinks()
    }
    //_________________________________________________//

    val settingsModel: SettingsModel = SettingsModel()

    //РАБОТА С SettingsModel

    fun updateMethodsNotification(TG: Boolean, App: Boolean) {
        settingsModel.updateMethods(TG, App)
    }

    fun updateCategoryNotification(category: String) {
        settingsModel.updateCategory(category)
    }
    //_________________________________________________//



    //ПОЛУЧЕНИЕ ЦВЕТОВ ИЗ РГБ(А)
    fun getRGBColor(red: Int, green: Int, blue: Int): Color {
        val hexColor = (red shl 16) or (green shl 8) or blue
        val myColor = Color(0xFF000000 or hexColor.toLong())
        return myColor
    }

    fun getRGBAColor(red: Int, green: Int, blue: Int, alpha: Int = 255): Color {
        require(red in 0..255) { "Red value must be between 0 and 255" }
        require(green in 0..255) { "Green value must be between 0 and 255" }
        require(blue in 0..255) { "Blue value must be between 0 and 255" }
        require(alpha in 0..255) { "Alpha value must be between 0 and 255" }

        val argbColor = (alpha shl 24) or (red shl 16) or (green shl 8) or blue
        return Color(argbColor.toLong())
    }

    //_________________________________________________//
}