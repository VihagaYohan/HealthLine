package com.techtribeservices.helathline.data.model

import com.techtribeservices.helathline.data.model.enums.AppointmentStatus

data class Appointment(
    val id: String,
    val appointmnetId: String,
    val doctor: Doctor,
    val hospital: String,
    val date: String,
    val time: String,
    val status: AppointmentStatus
)
