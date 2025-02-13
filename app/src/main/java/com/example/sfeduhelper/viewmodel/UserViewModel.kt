package com.example.sfeduhelper.viewmodel

import androidx.lifecycle.ViewModel
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

    fun setDirections() {
        userModel.setDirections()
    }
    //здесь должны быть абстрактные функции, которые вызывают функции в самой модели
}