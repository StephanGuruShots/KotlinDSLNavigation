package com.example.demodslnavigation.navigation.managers

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.presentation.core.NavigationRoute
import com.example.firstscreen.FirstScreenNavigationManager

class FirstScreenNavigationManagerImpl : FirstScreenNavigationManager {

    override fun Fragment.navigateToSecondScreen() {
        findNavController().navigate(NavigationRoute.SECOND_SCREEN)
    }

    override fun Fragment.navigateToTaskScreen() {
        findNavController().navigate(NavigationRoute.TASK_SCREEN)
    }

    override fun Fragment.navigateBack() {
        findNavController().popBackStack()
    }
}