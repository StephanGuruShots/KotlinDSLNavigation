package com.example.demodslnavigation.navigation.managers

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.presentation.models.NavigationRoute
import com.example.thirdscreen.ThirdScreenNavigationManager

class ThirdScreenNavigationManagerImpl : ThirdScreenNavigationManager{

    override fun Fragment.navigateBack() {
        findNavController().popBackStack()
    }

    override fun Fragment.navigateToBottomNavigation() {
        findNavController().navigate(NavigationRoute.BOTTOM_NAVIGATION)
    }
}