package com.example.thirdscreen

import androidx.fragment.app.Fragment

interface ThirdScreenNavigationManager {
    fun Fragment.navigateBack()
    fun Fragment.navigateToBottomNavigation()
}