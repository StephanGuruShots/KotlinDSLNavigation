package com.example.bottomnavigation.utils

import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

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