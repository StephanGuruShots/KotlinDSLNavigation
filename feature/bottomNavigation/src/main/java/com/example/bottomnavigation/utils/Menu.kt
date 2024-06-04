package com.example.bottomnavigation.utils

import android.view.Menu
import android.view.MenuItem
import com.example.bottomnavigation.R
import com.example.presentation.core.NavigationRoute


fun MenuItem.toRoute(): String {
    return when (this.itemId) {
        R.id.navigation_home -> NavigationRoute.HOME_SCREEN
        R.id.navigation_dashboard -> NavigationRoute.DASHBOARD_SCREEN
        R.id.navigation_notifications -> NavigationRoute.NOTIFICATIONS_SCREEN
        else -> ""
    }
}

fun String.toMenuItem(menu: Menu?): MenuItem? {
    if (menu == null) return null
    return when (this) {
        NavigationRoute.HOME_SCREEN -> menu.findItem(R.id.navigation_home)
        NavigationRoute.DASHBOARD_SCREEN -> menu.findItem(R.id.navigation_dashboard)
        NavigationRoute.NOTIFICATIONS_SCREEN -> menu.findItem(R.id.navigation_notifications)
        else -> null
    }
}