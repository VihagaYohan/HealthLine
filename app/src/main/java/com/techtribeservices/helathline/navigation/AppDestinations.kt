package com.techtribeservices.helathline.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.techtribeservices.helathline.R

enum class AppDestinations(
    @StringRes val label: Int,
    @DrawableRes val icon: Int,
    @StringRes val contentDescription: Int
) {
    Home(R.string.home, R.drawable.home, R.string.home),
    Appointment(R.string.appointment, R.drawable.calendar, R.string.appointment),
    Messages(R.string.messages, R.drawable.message, R.string.messages),
    Settings(R.string.settings, R.drawable.settings, R.string.settings)
}