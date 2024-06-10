package com.example.bottomnavigation.utils

import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigation.BottomNavigationFragment

fun navigateToBottomTab(item: MenuItem?, navController: NavController): Boolean {
    return try {
        if (item == null) return false
        item.isChecked = true
        navController.navigate(item.toRoute()) {

            navController.graph.findStartDestination().route?.let {
                popUpTo(
                    it
                ) {
                    inclusive = false
                    saveState = true
                }
            }

            launchSingleTop = true
            restoreState = true
        }
        true
    } catch (e: IllegalArgumentException) {
        false
    }
}

fun Fragment.navigateToBottomTabByRoute(route: String): Boolean {
    return try {
        val navController = findNavController()
        val menu = (parentFragment?.parentFragment as BottomNavigationFragment).menu

        val item = route.toMenuItem(menu)
        if (menu == null) return false
        if (item == null) return false
        item.isChecked = true
        navController.navigate(item.toRoute()) {

            navController.graph.findStartDestination().route?.let {
                popUpTo(
                    it
                ) {
                    inclusive = false
                    saveState = true
                }
            }

            launchSingleTop = true
            restoreState = true
        }
        true
    } catch (e: IllegalArgumentException) {
        false
    }
}