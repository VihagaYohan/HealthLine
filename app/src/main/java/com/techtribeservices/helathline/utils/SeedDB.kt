package com.techtribeservices.helathline.utils

import android.nfc.Tag
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.toObject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.techtribeservices.helathline.data.model.Appointment
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.data.model.mockData.appointmentsList
import com.techtribeservices.helathline.data.model.mockData.doctorsList
import com.techtribeservices.helathline.data.model.mockData.specialityList
import javax.inject.Inject

class SeedDB @Inject constructor(
    private val firestore: FirebaseFirestore,
) {
    private val batch = firestore.batch()

    // seed speciality collection
    fun seedSpeciality(): Unit {
        val specialityRef = firestore.collection(Collections.SPECIALITIES)

        specialityList.forEach { item ->
            val docRef = specialityRef.document()
            batch.set(docRef, item, SetOptions.merge())
        }

        batch.commit()
            .addOnSuccessListener {
                Log.d(Constants.TAG, "Speciality collection seeded successfully")
            }
            .addOnFailureListener {
                Log.d(Constants.TAG, "Speciality collection seeding failed")
            }
    }

    // seed doctors collection
    fun seedDoctors(): Unit {
        val listOfSpeciality: MutableList<Speciality> = mutableListOf()
        val specialityRef = firestore.collection(Collections.SPECIALITIES)
        specialityRef.get()
            .addOnSuccessListener { documents: QuerySnapshot ->
                documents.map { item ->
                    // convert document to speciality object
                    val gson = Gson()
                    val json = gson.toJson(item.data)
                    val speciality = gson.fromJson(json, Speciality::class.java)
                    // adding id to speciality object
                    val updated = speciality.copy(id = item.id)
                    listOfSpeciality.add(updated)
                }

                if (listOfSpeciality.isNotEmpty()) {
                    val doctorRef = firestore.collection(Collections.DOCTORS)
                    val batch = firestore.batch() // initialize batch

                    doctorsList.forEach { doctor ->
                        val docRef = doctorRef.document()
                        val randomSpeciality: Speciality = listOfSpeciality.random()

                        // update doctor object
                        val updatedDoctor = doctor.copy(speciality = randomSpeciality)
                        batch.set(docRef, updatedDoctor, SetOptions.merge())
                    }

                    batch.commit()
                        .addOnSuccessListener {
                            Log.d(Constants.TAG, "Doctors collection seed successfully")
                        }
                        .addOnFailureListener {
                            Log.d(Constants.TAG, "Doctors collection seeding failed")
                        }
                } else {
                    Log.d(Constants.TAG, "Speciality collection is empty")
                }
            }
        Log.d(Constants.TAG, "list of speciality: ${listOfSpeciality.size}")
    }

    // seed appointments collection
    fun seedAppointments(): Unit {
        var listOfAppointments : MutableList<Appointment> = mutableListOf()
        var appointmentRef = firestore.collection(Collections.APPOINTMENTS)

        appointmentsList.forEach { appointment ->
            val appointmentDocRef = appointmentRef.document()
            batch.set(appointmentDocRef, appointment, SetOptions.merge())
        }

        batch.commit()
            .addOnSuccessListener {
                Log.d(Constants.TAG, "Appointments collection seeded successfully")
            }
            .addOnFailureListener {
                Log.d(Constants.TAG, "Appointments collection seeding failed")
            }
    }
}