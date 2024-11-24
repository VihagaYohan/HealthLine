package com.techtribeservices.helathline.domain.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.toObject
import com.google.gson.Gson
import com.techtribeservices.helathline.data.model.Doctor
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.utils.Collections
import com.techtribeservices.helathline.utils.Constants
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class DoctorRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    // fetch all speciality from firestore
    suspend fun getAllSpecialities(): MutableList<Speciality> {
        val specialityList: MutableList<Speciality> = mutableListOf()

        firestore.collection(Collections.SPECIALITIES)
            .get()
            .await()
            .map {
                val result = it.toObject(Speciality::class.java)
                specialityList.add(result)
            }
        return specialityList
    }

    // fetch all doctors from firestore
    suspend fun getAllDoctors(): MutableList<Doctor> {
        val doctorList: MutableList<Doctor> = mutableListOf()
        val doctorRef = firestore.collection(Collections.DOCTORS)
        doctorRef.get()
            .await()
            .map { item ->
                val gson = Gson()
                val json = gson.toJson(item.data)
                val doctor = gson.fromJson(json, Doctor::class.java)
                val updatedDoctor = doctor.speciality?.let {
                    Doctor(
                        id = item.id,
                        surname = doctor.surname,
                        firstName = doctor.firstName,
                        lastName = doctor.lastName,
                        title = doctor.title,
                        speciality = it,
                        profileImage = doctor.profileImage,
                    )
                }
                if (updatedDoctor != null) {
                    doctorList.add(updatedDoctor)
                }
            }
        return doctorList
    }
}