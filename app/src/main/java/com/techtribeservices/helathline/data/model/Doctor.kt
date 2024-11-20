package com.techtribeservices.helathline.data.model

import com.google.firebase.Timestamp
import com.techtribeservices.helathline.data.model.enums.UserRoles

data class Doctor(
    private val title: String = "",
    val speciality: Speciality? = null, //= Speciality("", Timestamp.now(), UserRoles.ADMIN),
    val profileImage: String = "",
) : Person(surname = "", firstName = "", lastName = "") {

    // override full name and return the full name along with title
    override fun fullName(): String {
        val fullName = super.fullName()
        return "$title. $fullName"
    }
}