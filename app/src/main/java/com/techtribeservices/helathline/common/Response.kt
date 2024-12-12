package com.techtribeservices.helathline.common

sealed class Response<out T>{
    data class Success<out T>(val data:Any): Response<T>()
    data class Error<T>(val errorMessage: String): Response<Nothing>()
    data object Loading: Response<Nothing>()
}