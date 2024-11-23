package com.techtribeservices.helathline.navigation.destinations

import android.graphics.pdf.content.PdfPageGotoLinkContent.Destination
import android.os.Parcelable
import com.techtribeservices.helathline.data.model.Doctor
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    data object Onboarding: Destinations()

    @Serializable
    data object Login: Destinations()

    @Serializable
    data object Register: Destinations()

    @Serializable
    data object MainPage: Destinations()

    @Serializable
    data class DoctorDetails(val doctorId: String): Destinations()
}
