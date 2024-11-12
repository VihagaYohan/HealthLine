package com.techtribeservices.helathline.utils

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.techtribeservices.helathline.data.model.mockData.doctorsList
import com.techtribeservices.helathline.data.model.mockData.specialityList
import javax.inject.Inject

class SeedDB @Inject constructor(
    private val firestore: FirebaseFirestore,
) {
    val batch = firestore.batch()

    // seed speciality collection
    fun seedSpeciality(): Unit {
        val specialityRef = firestore.collection(Collections.SPECIALITIES)

        specialityList.forEach { item ->
            val docRef = specialityRef.document()
            batch.set(docRef, item, SetOptions.merge())
        }

        batch.commit()
            .addOnSuccessListener {
                Log.d("HealthLine", "Speciality collection seeded successfully")
            }
            .addOnFailureListener {
                Log.d("HealhLine", "Speciality collection seeding failed")
            }
    }

    // seed doctors collection
    fun seedDoctors(): Unit {
        val doctorRef = firestore.collection(Collections.DOCTORS)

        doctorsList.forEach { doctor ->
            val docRef = doctorRef.document()
            batch.set(docRef, doctor, SetOptions.merge())
        }

        batch.commit()
            .addOnSuccessListener {
                Log.d(Constants.TAG, "Doctors collection seed successfully")
            }.addOnFailureListener {
                Log.d(Constants.TAG, "Doctors collection seeding failed")
            }
    }
}