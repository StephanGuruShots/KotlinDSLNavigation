package com.example.presentation.models

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import kotlinx.parcelize.Parcelize
import androidx.navigation.NavType
import com.example.presentation.utils.parcelable
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
@Parcelize
data class User(
    val name: String,
    val age: Int
) : Parcelable

val UserType = object : NavType<User>(
    isNullableAllowed = false
) {
    override fun put(bundle: Bundle, key: String, value: User) {
        Log.d("rawr","put")
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): User? {
        Log.d("rawr","get")

        return bundle.parcelable<User>(key)
    }

    override fun parseValue(value: String): User {
        Log.d("rawr","parseValue")

        return Json.decodeFromString<User>(value)
    }
}