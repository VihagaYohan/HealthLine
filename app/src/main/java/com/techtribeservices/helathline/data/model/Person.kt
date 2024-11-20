package com.techtribeservices.helathline.data.model

import com.google.gson.annotations.SerializedName

open class Person(
//   @SerializedName("surname") open val surname:String = "",
//   @SerializedName("firstName") open val firstName:String = "",
//   @SerializedName("lastName") open val lastName:String = "",
    val surname:String = "",
    val firstName: String = "",
    val lastName: String = "") {

    // return person name
    open fun fullName():String {
        return "$surname $firstName, $lastName"
    }
}