package com.techtribeservices.helathline.data.model

data class PatientReview(
    val patientName: String,
    val rating: Float,
    val review: String,
    val reviewDate: String
)