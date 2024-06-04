package com.example.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductDetails(
    val productId: String,
    val productName: String? = null // Optional argument
) : Parcelable
