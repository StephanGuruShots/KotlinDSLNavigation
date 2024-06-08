package com.example.bottomnavigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigation.databinding.FragmentBottomNavigationBinding
import com.example.bottomnavigation.ui.dashboard.DashboardFragment
import com.example.bottomnavigation.ui.home.HomeFragment
import com.example.bottomnavigation.ui.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavigationFragment : Fragment() {

    private lateinit var binding: FragmentBottomNavigationBinding

    var menu: Menu? = null

    private var parentNavController: NavController? = null
    private lateinit var navHostFragment: NavHostFragment


    val TAG = "BottomNavigationFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        Log.d("rawr", "$TAG: onCreateView")

        parentNavController = findNavController()

        binding = FragmentBottomNavigationBinding.inflate(layoutInflater)

        val navHostFragment =
            this.childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        navController.graph = navController.createGraph(startDestination = NavigationRoute.HOME_SCREEN) {
//            fragment<HomeFragment>(NavigationRoute.HOME_SCREEN) {
//                label = "Home"
//            }
//            fragment<DashboardFragment>(NavigationRoute.DASHBOARD_SCREEN) {
//                label = "Dashboard"
//            }
//            fragment<NotificationsFragment>(NavigationRoute.NOTIFICATIONS_SCREEN) {
//                label = "Notifications"
//            }
//        }
//
//        menu = binding.bottomNavigation.menu

        val bottomNavigationView =
            binding.root.findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        bottomNavigationView.setupWithNavController(navController)

//        bottomNavigationView.setOnItemSelectedListener { item ->
//            navigateToBottomTab(item, navController)
//        }

        this.navHostFragment = navHostFragment

        bottomNavigationView.setupWithNavController(navHostFragment.navController)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navigateToFragment(getFragmentByTag("screen1"), "screen1")
//                    navigateToTabByTag("screen1")
//                    reorderBackStack(listOf("screen2", "screen3", "screen1"))
                    true
                }

                R.id.navigation_dashboard -> {
                    navigateToFragment(getFragmentByTag("screen2"), "screen2")

//                    navigateToTabByTag("screen2")
                    true
                }

                R.id.navigation_notifications -> {
                    changeFragmentPositionInBackStack("screen1", 3)
//                    navigateToTabByTag("screen3")
                    true
                }

                else -> false
            }
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

//        viewLifecycleOwner.lifecycleScope.launch {
//            while (true) {
//
//                val fragmentManager = childFragmentManager
//                val backStackCount = fragmentManager.backStackEntryCount
//
//                Log.d("rawr", "BackStackEntryCount: $backStackCount")
//                for (i in 0 until backStackCount) {
//                    val backStackEntry = fragmentManager.getBackStackEntryAt(i)
//                    Log.d("rawr", "Entry $i: ${backStackEntry.name}")
//                }
//
//                delay(2000)
//            }
//        }

        // [0, -1121921303, 467400570, 714640678]

        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.nav_host_fragment, HomeFragment(), "screen1")
        transaction.addToBackStack("screen1")
        transaction.add(R.id.nav_host_fragment, HomeFragment(), "screen1")
        transaction.addToBackStack("screen1")
//        transaction.add(R.id.nav_host_fragment, DashboardFragment(), "screen2")
//        transaction.add(R.id.nav_host_fragment, NotificationsFragment(), "screen3")
        transaction.commit()

        val fragmentManager = childFragmentManager
        val backStackCount = fragmentManager.backStackEntryCount

        Log.d("rawr", "BackStackEntryCount: $backStackCount")
        for (i in 0 until backStackCount) {
            val backStackEntry = fragmentManager.getBackStackEntryAt(i)
            Log.d("rawr", "Entry $i: ${backStackEntry.name}")
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
        parentNavController?.popBackStack()
    }

    private fun navigateToTabByTag(tag: String) {

        Log.d("rawr","navigateToTabByTag = ${tag}")


        val targetFragment = childFragmentManager.findFragmentByTag(tag)

        if (targetFragment == null) {
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, getFragmentByTag(tag), tag)
            transaction.addToBackStack(tag)
            transaction.commit()
        } else {
            val count = childFragmentManager.backStackEntryCount

            val tags: MutableList<String?> = (0..<count).map {
                childFragmentManager.getBackStackEntryAt(it).name
            }.toMutableList()

            tags.remove(tag)

            val transaction = childFragmentManager.beginTransaction()

            val fragments = tags.mapNotNull { childFragmentManager.findFragmentByTag(it) }

            tags.forEach {
                childFragmentManager.findFragmentByTag(it)?.let { fragment ->
                    transaction.remove(fragment)
                }
            }

            fragments.forEach {
                transaction.add(R.id.nav_host_fragment, it, it.tag)
                transaction.addToBackStack(it.tag)
            }

            transaction.replace(R.id.nav_host_fragment, targetFragment, tag)
            transaction.addToBackStack(tag)
            transaction.commit()


//            transaction
//                .replace(R.id.nav_host_fragment, targetFragment, tag)
//                .addToBackStack(tag)
//                .commit()

//            val fragmentManager = childFragmentManager
//            val backStackCount = fragmentManager.backStackEntryCount
//
//            Log.d("rawr", "BackStackEntryCount: $backStackCount")
//            for (i in 0 until backStackCount) {
//                val backStackEntry = fragmentManager.getBackStackEntryAt(i)
//                Log.d("rawr", "Entry $i: ${backStackEntry.name}")
//            }
//
//            val transaction = childFragmentManager.beginTransaction()
//            fragments.forEachIndexed { index, fragment ->
//                when(index) {
//                    0 -> transaction.add(R.id.nav_host_fragment, fragment, fragment.tag)
//                    count - 1 -> transaction.replace(R.id.nav_host_fragment, fragment, fragment.tag)
//                    else -> transaction.replace(R.id.nav_host_fragment, fragment, fragment.tag)
//                }
//                transaction.addToBackStack(fragment.tag)
//            }
//            transaction.commit()

        }



        val fragmentManager = childFragmentManager
        val backStackCount = fragmentManager.backStackEntryCount



        Log.d("rawr", "BackStackEntryCount: $backStackCount")
        for (i in 0 until backStackCount) {
            val backStackEntry = fragmentManager.getBackStackEntryAt(i)
            Log.d("rawr", "Entry $i: ${backStackEntry.name}")
        }
    }

    private fun navigateToFragment(tag: String) {

        Log.d("rawr","navigateToFragment = ${tag}")

        val fragment = childFragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment, tag)
                .addToBackStack(tag)
                .commit()
        } else {

            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, getFragmentByTag(tag), tag)
            transaction.addToBackStack(tag)
            transaction.commit()
        }

        val fragmentManager = childFragmentManager
        val backStackCount = fragmentManager.backStackEntryCount

        Log.d("rawr", "BackStackEntryCount: $backStackCount")
        for (i in 0 until backStackCount) {
            val backStackEntry = fragmentManager.getBackStackEntryAt(i)
            Log.d("rawr", "Entry $i: ${backStackEntry.name}")
        }

        Log.d("rawr","loolollolol = ${childFragmentManager.fragments}")

        childFragmentManager.fragments.forEach {
            Log.d("rawr","loolollolol = ${it}")
        }
    }

    private fun reorderBackStack(newStack: List<String>) {
        val fragmentManager = childFragmentManager
        val fragments = newStack.mapNotNull { tag -> fragmentManager.findFragmentByTag(tag) }

        // Pop all fragments from the back stack
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

//        fragmentManager.clearBackStack("")

        // Re-add the fragments in the new order
        val transaction = fragmentManager.beginTransaction()
        fragments.forEach { fragment ->
            transaction.replace(R.id.nav_host_fragment, fragment, fragment.tag)
            transaction.addToBackStack(fragment.tag)
        }
        transaction.commit()
    }

    private fun getFragmentIdByTag(tag: String): Int {
        return when (tag) {
            "screen1" -> R.layout.fragment_home
            "screen2" -> R.layout.fragment_dashboard
            "screen3" -> R.layout.fragment_notifications
            else -> throw IllegalArgumentException("Unknown fragment tag")
        }
    }

    private fun getFragmentByTag(tag: String): Fragment {
        return when (tag) {
            "screen1" -> HomeFragment()
            "screen2" -> DashboardFragment()
            "screen3" -> NotificationsFragment()
            else -> throw IllegalArgumentException("Unknown fragment tag")
        }
    }

    private fun clearBackStack() {
        val fragmentManager = childFragmentManager
        if (fragmentManager.backStackEntryCount > 0) {
            val first = fragmentManager.getBackStackEntryAt(0)
            fragmentManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        childFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        childFragmentManager.popBackStackImmediate()
    }

    private fun navigateToFragment(fragment: Fragment, tag: String) {
        childFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment, tag)
            .addToBackStack(tag)
            .commit()

        val fragmentManager = childFragmentManager
        val backStackCount = fragmentManager.backStackEntryCount

        Log.d("rawr", "BackStackEntryCount: $backStackCount")
        for (i in 0 until backStackCount) {
            val backStackEntry = fragmentManager.getBackStackEntryAt(i)
            Log.d("rawr", "Entry $i: ${backStackEntry.name}")
        }
    }

    private fun detachFragment(tag: String) {
        val fragmentManager = childFragmentManager
        val fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            fragmentManager.beginTransaction().detach(fragment).commit()
        }
    }

    private fun attachFragment(tag: String) {
        val fragmentManager = childFragmentManager
        val fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            fragmentManager.beginTransaction().attach(fragment).commit()
        }
    }

    private fun changeFragmentPositionInBackStack(tag: String, newPosition: Int) {
        val fragmentManager = childFragmentManager

        // Find the fragment by tag
        val fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            // Detach the fragment instead of removing it
            fragmentManager.beginTransaction().detach(fragment).commit()

            // Create a list of back stack entries
            val backStackEntries = mutableListOf<Fragment>()
            for (i in 0 until fragmentManager.backStackEntryCount) {
                val entryTag = fragmentManager.getBackStackEntryAt(i).name
                val entryFragment = fragmentManager.findFragmentByTag(entryTag)
                if (entryFragment != null) {
                    backStackEntries.add(entryFragment)
                }
            }

            // Remove all fragments from the back stack
            for (i in 0 until fragmentManager.backStackEntryCount) {
                fragmentManager.popBackStack()
            }

            // Insert the fragment at the new position
            if (newPosition >= 0 && newPosition < backStackEntries.size) {
                backStackEntries.remove(fragment)
                backStackEntries.add(newPosition, fragment)
            }

            // Re-add all fragments in the new order
            val transaction = fragmentManager.beginTransaction()
            backStackEntries.forEach { entryFragment ->
                transaction.attach(entryFragment)
                transaction.addToBackStack(entryFragment.tag)
            }
            transaction.commit()
        }

        val backStackCount = fragmentManager.backStackEntryCount

        Log.d("rawr", "BackStackEntryCount: $backStackCount")
        for (i in 0 until backStackCount) {
            val backStackEntry = fragmentManager.getBackStackEntryAt(i)
            Log.d("rawr", "Entry $i: ${backStackEntry.name}")
        }
    }
}

