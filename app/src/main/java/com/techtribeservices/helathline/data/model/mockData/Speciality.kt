package com.techtribeservices.helathline.data.model.mockData

import com.google.firebase.Timestamp
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.data.model.enums.UserRoles

val specialityList: List<Speciality> = listOf(
    Speciality(
        "",
        "Cardiology",
        iconId = R.drawable.heartbeat_solid,
        Timestamp.now(),
        UserRoles.ADMIN
    ),
    Speciality(
        "",
        "Eye Surgeon",
        iconId = R.drawable.eye_solid,
        Timestamp.now(),
        UserRoles.ADMIN
    ),
    Speciality(
        "",
        "Pediatrician",
        iconId = R.drawable.baby_solid,
        Timestamp.now(),
        UserRoles.ADMIN
    ),
    Speciality(
        "",
        "Neurologist",
        iconId = R.drawable.brain_solid,
        Timestamp.now(),
        UserRoles.ADMIN
    ),
    Speciality(
        "",
        title ="Dentist",
        iconId = R.drawable.tooth_solid,
        Timestamp.now(),
        UserRoles.ADMIN
    ),
)