package com.techtribeservices.helathline.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.techtribeservices.helathline.data.model.Speciality
import com.techtribeservices.helathline.utils.Collections
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
}