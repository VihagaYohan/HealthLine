package com.techtribeservices.helathline.data.model

import com.google.firebase.Timestamp

data class Speciality(
    val title: String = "",
    val modifiedTS: Timestamp = Timestamp.now(),
    val modifiedBy: String = "Admin"
)