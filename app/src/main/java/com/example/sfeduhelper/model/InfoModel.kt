package com.example.sfeduhelper.model

import com.example.sfeduhelper.classes.InfoInstitute

class InfoModel {

    var infoInstitutes: MutableList<InfoInstitute> = mutableListOf()

    fun addInfoInstitute(nameInstitute: String, descInstitute: String) {
        infoInstitutes.add(
            InfoInstitute(nameInstitute, descInstitute)
        )
    }

    fun getInfoInstitute(nameInstitute: String): String {
        val info = infoInstitutes.firstOrNull {it.name == nameInstitute}
        return info?.desc ?: ""
    }
}