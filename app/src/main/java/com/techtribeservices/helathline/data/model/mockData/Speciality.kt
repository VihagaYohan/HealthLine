package com.techtribeservices.helathline.data.model.mockData

import com.google.firebase.Timestamp
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.data.model.enums.UserRoles

val specialityList: List<Speciality> = listOf(
    Speciality(
        "Cardiology",
        Timestamp.now(),
        UserRoles.ADMIN
    ),
    Speciality(
        "Dermatology",
        Timestamp.now(),
        UserRoles.ADMIN
    ),
    Speciality(
        "Endocrinology",
        Timestamp.now(),
        UserRoles.ADMIN
    ),
    Speciality(
        "Gastroenterology",
        Timestamp.now(),
        UserRoles.ADMIN
    ),
    Speciality(
        "Hematology",
        Timestamp.now(),
        UserRoles.ADMIN
    ),
    Speciality(
        "Infectious Disease",
        Timestamp.now(),
        UserRoles.ADMIN
    ),
    Speciality(
        "Neurology",
        Timestamp.now(),
        UserRoles.ADMIN
    ),
)