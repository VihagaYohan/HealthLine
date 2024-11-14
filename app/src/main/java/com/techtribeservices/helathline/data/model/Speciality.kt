package com.techtribeservices.helathline.data.model

import com.google.firebase.Timestamp
import com.techtribeservices.helathline.data.model.enums.UserRoles

data class Speciality(
    var id: String = "",
    val title: String = "",
    val iconId: Int,
    val modifiedTS: Timestamp = Timestamp.now(),
    val modifiedBy: UserRoles = UserRoles.ADMIN
)