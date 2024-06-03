package com.example.bottomnavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.fragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigation.databinding.FragmentBottomNavigationBinding
import com.example.bottomnavigation.ui.dashboard.DashboardFragment
import com.example.bottomnavigation.ui.home.HomeFragment
import com.example.bottomnavigation.ui.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import javax.inject.Inject

@AndroidEntryPoint
class BottomNavigationFragment : Fragment() {

    private lateinit var binding: FragmentBottomNavigationBinding

    var menu: Menu? = null

    @Inject
    lateinit var navigationManager: BottomNavigationScreenNavigationManager

    private var parentNavController: NavController? = null

    val TAG = "BottomNavigationFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        Log.d("rawr", "$TAG: onCreateView")

        parentNavController = findNavController()

        viewLifecycleOwner.lifecycleScope.launch {
            parentNavController?.currentBackStack?.collect() {
                val x = it.map { it.destination.route }
                Log.d("rawr", "currentBackStack: ${x}")
            }
        }

        binding = FragmentBottomNavigationBinding.inflate(layoutInflater)

        val navHostFragment =
            this.childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.graph = navController.createGraph(startDestination = "home") {
            fragment<HomeFragment>("home") {
                label = "Home"
            }
            fragment<DashboardFragment>("dashboard") {
                label = "Dashboard"
            }
            fragment<NotificationsFragment>("notifications") {
                label = "Notifications"
            }
        }

//        val menu = binding.bottomNavigation.menu
//
//        navController.graph = navController.createGraph(startDestination = menu.findItem(R.id.navigation_home).itemId) {
//            fragment<HomeFragment>(menu.findItem(R.id.navigation_home).itemId) {
//                label = "Home"
//            }
//            fragment<DashboardFragment>(menu.findItem(R.id.navigation_dashboard).itemId) {
//                label = "Dashboard"
//            }
//            fragment<NotificationsFragment>(menu.findItem(R.id.navigation_notifications).itemId) {
//                label = "Notifications"
//            }
//        }

        //2131231048
        //2131231046
        //2131231049

        menu = binding.bottomNavigation.menu

        val bottomNavigationView =
            binding.root.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnItemSelectedListener { item ->
            onNavDestinationSelected(item, navController)
        }

//        bottomNavigationView.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.navigation_home -> {
//                    navController.navigate("home") {
//
//
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                    true
//                }
//                R.id.navigation_dashboard -> {
//                    navController.navigate("dashboard"){
//                        launchSingleTop = true
//                        restoreState = true
//
//
//                    }
//                    true
//                }
//                R.id.navigation_notifications -> {
//                    navController.navigate("notifications") {
//                        launchSingleTop = true
//                        restoreState = true
//
//
//
//                    }
//                    true
//                }
//                else -> false
//            }
//        }

//        bottomNavigationView.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.navigation_home -> {
//                    navController.navigate("home") {
//                        popUpTo("home")
//                    }
//                }
//
//                R.id.navigation_dashboard -> {
//                    navController.navigate("dashboard"){
//                        popUpTo("home")
//                    }
//                }
//
//                R.id.navigation_notifications -> {
//                    navController.navigate("notifications"){
//                        popUpTo("home")
//                    }
//                }
//
//                else -> {
//
//                }
//            }
//            return@setOnItemSelectedListener true
//        }

        viewLifecycleOwner.lifecycleScope.launch {
            navController.currentBackStack.collect() {
                val x = it.map { it.destination.route }
                Log.d("rawr", "currentBackStack: ${x}")
            }
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("rawr", "$TAG: onViewCreated")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("rawr", "$TAG: onDestroy")

    }

    override fun onPause() {
        super.onPause()

        Log.d("rawr", "$TAG: onPause")

    }

    override fun onStart() {
        super.onStart()

        Log.d("rawr", "$TAG: onStart")

    }

    override fun onStop() {
        super.onStop()

        Log.d("rawr", "$TAG: onStop")

    }

    override fun onResume() {
        super.onResume()

        Log.d("rawr", "$TAG: onResume")

    }

    fun navigateBack() {
        with(navigationManager) {
            parentNavController?.navigateBack()
        }
    }
}

fun onNavDestinationSelected(item: MenuItem, navController: NavController): Boolean {
    return try {
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

fun MenuItem.toRoute(): String {
    return when (this.itemId) {
        R.id.navigation_home -> "home"
        R.id.navigation_dashboard -> "dashboard"
        R.id.navigation_notifications -> "notifications"
        else -> ""
    }
}

fun String.toMenuItem(menu: Menu): MenuItem? {
    return when (this) {
        "home" -> menu.findItem(R.id.navigation_home)
        "dashboard" -> menu.findItem(R.id.navigation_dashboard)
        "notifications" -> menu.findItem(R.id.navigation_notifications)
        else -> null
    }
}