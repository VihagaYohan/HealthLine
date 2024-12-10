package com.techtribeservices.helathline.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.techtribeservices.helathline.data.model.Appointment
import com.techtribeservices.helathline.utils.Collections
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AppointmentRepository @Inject constructor(
    private val firestore: FirebaseFirestore
){
    // fetch all appointments from firestore
    suspend fun getAllAppointments(): MutableList<Appointment> {
        val appointmentList: MutableList<Appointment> = mutableListOf()

        firestore.collection(Collections.APPOINTMENTS)
            .get()
            .await()
            .map {
                val result = it.toObject(Appointment::class.java)
                appointmentList.add(result)
            }
        return appointmentList
    }
}