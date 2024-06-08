package com.example.presentation.utils

import android.net.Uri
import com.example.presentation.models.BaseNavArgument
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun BaseNavArgument.encodeToUri(): String {
    return Uri.encode(Json.encodeToString(this))
}