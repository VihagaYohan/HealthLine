package com.techtribeservices.helathline.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AppointmentRepository @Inject constructor(
    private val firestore: FirebaseFirestore
){
    // fetch all appointments from firestore

}