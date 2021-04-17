package com.afinaufal.androiddasar.news.util

sealed class Resource<T>(
    val data:T? = null,
    val message:String? = null
) {
    class Succes<T>(data:T):Resource<T>(data)
    class Error<T>(data:T, message: String?):Resource<T>(data, message)
    class Loading<T>:Resource<T>()
}