package com.example.firstscreen

import androidx.fragment.app.Fragment

interface FirstScreenNavigationManager {
    fun Fragment.navigateToSecondScreen()
    fun Fragment.navigateToTaskScreen()
    fun Fragment.navigateBack()
}