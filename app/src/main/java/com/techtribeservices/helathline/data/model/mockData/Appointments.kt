package com.techtribeservices.helathline.data.model.mockData

import com.techtribeservices.helathline.data.model.Appointment
import com.techtribeservices.helathline.data.model.enums.AppointmentStatus
import java.util.UUID

val appointmentsList: List<Appointment> = listOf(
    Appointment(
        id = "1",
        appointmnetId = UUID.randomUUID().toString(),
        doctor = doctorsList[0],
        hospital = "Asiri Hospital",
        date = "2024 Dec 2",
        time = "10:00 AM",
        status = AppointmentStatus.COMPLETED
    )
)
