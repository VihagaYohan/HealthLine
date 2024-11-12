package com.techtribeservices.helathline.data.model.mockData

import com.google.firebase.Timestamp
import com.techtribeservices.helathline.data.model.Doctor
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.data.model.enums.UserRoles

val doctorsList: List<Doctor> = listOf(
    Doctor(
        "Doe",
        "John",
        "Smith",
        "Dr",
        Speciality("Cardiology", Timestamp.now(), UserRoles.ADMIN),
        "https://fzzypoxsybnlbgvtudxm.supabase.co/storage/v1/object/public/healthline/doctors/1.png"
    )
)