package com.example.seconscreen

import androidx.fragment.app.Fragment
import com.example.presentation.models.User

interface SecondScreenNavigationManager {
    fun Fragment.navigateToThirdScreen(amount: Int, value: String, user: User)
    fun Fragment.navigateBack()
}