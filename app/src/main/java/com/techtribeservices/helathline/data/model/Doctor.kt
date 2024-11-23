package com.techtribeservices.helathline.data.model


data class Doctor(
    private val title: String = "",
    val speciality: Speciality? = null,
    val profileImage: String = "",
) : Person(surname = "", firstName = "", lastName = "") {
    constructor(
        surname: String,
        firstName: String,
        lastName: String,
        title: String,
        speciality: Speciality,
        profileImage: String
    ) : this(
        title, speciality, profileImage
    ) {
        this.surname = surname
        this.firstName = firstName
        this.lastName = lastName
    }

    // override full name and return the full name along with title
    override fun fullName(): String {
        val fullName = super.fullName()
        return "$title. $fullName"
    }
}