package com.techtribeservices.helathline.data.model.mockData

import com.techtribeservices.helathline.data.model.PatientReview

val patientReviews: List<PatientReview> = listOf(
    PatientReview(
        patientName = "John Doe",
        rating = 4.5f,
        review = "Dr. Smith was very attentive and provided excellent care. Highly recommended!",
        reviewDate = "2024-12-01"
    ),
    PatientReview(
        patientName = "Jane Smith",
        rating = 3.0f,
        review = "The consultation was okay, but the waiting time was too long.",
        reviewDate = "2024-11-28"
    ),
    PatientReview(
        patientName = "Michael Brown",
        rating = 5.0f,
        review = "Fantastic experience! Dr. Smith is very professional and caring.",
        reviewDate = "2024-11-15"
    ),
    PatientReview(
        patientName = "Emily Davis",
        rating = 4.0f,
        review = "Good service overall. The staff was friendly, and Dr. Smith explained everything clearly.",
        reviewDate = "2024-12-02"
    ),
    PatientReview(
        patientName = "Chris Wilson",
        rating = 2.5f,
        review = "I felt rushed during the consultation, and my concerns were not fully addressed.",
        reviewDate = "2024-11-10"
    )
)