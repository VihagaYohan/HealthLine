package com.techtribeservices.helathline.data.model


data class Doctor(
    var title: String = "",
    var speciality: Speciality? = null,
    var profileImage: String = "",
) : Person(id = "", surname = "", firstName = "", lastName = "") {
    constructor(
        id: String,
        surname: String,
        firstName: String,
        lastName: String,
        title: String,
        speciality: Speciality,
        profileImage: String
    ) : this(
        title, speciality, profileImage
    ) {
        this.id = id
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