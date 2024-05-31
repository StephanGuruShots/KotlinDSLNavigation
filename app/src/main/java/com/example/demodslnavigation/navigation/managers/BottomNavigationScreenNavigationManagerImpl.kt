package com.example.demodslnavigation.navigation.managers

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigation.BottomNavigationScreenNavigationManager

class BottomNavigationScreenNavigationManagerImpl : BottomNavigationScreenNavigationManager {
    override fun NavController.navigateBack() {
        this.popBackStack()
    }
}