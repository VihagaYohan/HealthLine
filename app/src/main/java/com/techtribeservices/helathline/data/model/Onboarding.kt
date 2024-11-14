package com.techtribeservices.helathline.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Onboarding(
    @DrawableRes val image:Int,
    @StringRes val title: Int,
    @StringRes val subTitle: Int
)
