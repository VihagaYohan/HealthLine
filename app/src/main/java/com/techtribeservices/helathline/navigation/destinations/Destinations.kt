package com.techtribeservices.helathline.navigation.destinations

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    data object Login: Destinations()

    @Serializable
    data object Register: Destinations()

    @Serializable
    data class Profile(val name: String): Destinations()

    @Serializable
    data object FriendsList: Destinations()

    @Serializable
    data class ProfileData(val name:String, val age:Int): Destinations()
}