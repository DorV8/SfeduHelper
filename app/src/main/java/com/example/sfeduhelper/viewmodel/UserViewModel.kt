package com.example.sfeduhelper.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.sfeduhelper.classes.Link
import com.example.sfeduhelper.classes.User
import com.example.sfeduhelper.model.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel: ViewModel() {
    val userModel: UserModel = UserModel()
    private val _user = MutableStateFlow(userModel.getUser())
    val user: StateFlow<User> get() = _user

    fun saveUserName(name: String) {
        userModel.saveUser(name)
        _user.value = userModel.getUser()
    }

    fun addDirectionToUser(codeDirection: String, levelPriority: Int){
        userModel.AddDirection(codeDirection, levelPriority)
        _user.value = userModel.getUser()
    }

    fun getSelectedCodeDirections(): List<String>{
        return  userModel.getSelectedCodeDirections()
    }

    fun getAllCodeDirections(): List<String>{
        return userModel.getAllCodeDirections()
    }

    fun getSelectedNameDirections(): List<String> {
        return userModel.getSelectedNameDirections()
    }

    fun getAllNameDirections(): List<String> {
        return userModel.getAllNameDirections()
    }

    fun selectCodeDirectionsBySctruct(nameStruct: String): List<String>{
        return userModel.selectCodeDirectionsBySctruct(nameStruct)
    }

    fun setDirections() {
        userModel.setDirections()
    }

    fun setLinks() {
        userModel.setLinks()
    }
    fun getLinks(): MutableList<Link> {
        return userModel.getLinks()
    }
    //здесь должны быть абстрактные функции, которые вызывают функции в самой модели


    fun getRGBColor(red: Int, green: Int, blue: Int): Color {
        val hexColor = (red shl 16) or (green shl 8) or blue
        val myColor = Color(0xFF000000 or hexColor.toLong())
        return myColor
    }

    fun setAfter(after: String){
        userModel.setAfter(after)
    }

    fun getAfter() {
        userModel.getAfter()
    }
}