package com.techtribeservices.helathline.navigation.destinations

import android.os.Parcelable
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
}
