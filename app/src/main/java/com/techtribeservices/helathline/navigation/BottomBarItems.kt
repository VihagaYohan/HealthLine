package com.techtribeservices.helathline.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.techtribeservices.helathline.R

enum class BottomBarItems(
    @StringRes val label:Int,
    @DrawableRes val icon: Int,
) {
    Home(R.string.home, R.drawable.home),
    Appointment(R.string.appointment, R.drawable.calendar),
    Messages(R.string.messages,R.drawable.message),
    Profile(R.string.settings, R.drawable.settings)
}