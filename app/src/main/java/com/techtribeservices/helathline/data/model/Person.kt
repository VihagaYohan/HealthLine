package com.techtribeservices.helathline.data.model

open class Person(
    open val surname:String,
    open val firstName:String,
    open val lastName:String,
) {
    // return person name
    open fun fullName():String {
        return "$firstName $lastName, $surname"
    }
}