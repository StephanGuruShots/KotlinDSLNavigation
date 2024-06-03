package com.example.demodslnavigation.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavType
import androidx.navigation.createGraph
import com.example.demodslnavigation.R
import com.example.demodslnavigation.databinding.FragmentMainBinding
import com.example.firstscreen.FirstFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.fragment
import androidx.navigation.navArgument
import com.example.bottomnavigation.BottomNavigationFragment
import com.example.demodslnavigation.MainActivity
import com.example.presentation.models.NavigationArguments
import com.example.presentation.models.NavigationRoute
import com.example.demodslnavigation.navigation.utils.destinationString
import com.example.firstscreen.TaskFragment
import com.example.fourthscreen.FourthFragment
import com.example.presentation.models.User
import com.example.presentation.models.UserType
import com.example.seconscreen.SecondFragment
import com.example.thirdscreen.ThirdFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val TAG = "MainFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        Log.d("rawr", "$TAG: onCreateView")

        binding = FragmentMainBinding.inflate(layoutInflater)

        val navHostFragment =
            this.childFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.findNavController()

        (requireActivity() as MainActivity).navController = navController

        navController.graph = navController.createGraph(
            startDestination = NavigationRoute.FIRST_SCREEN
        ) {
            fragment<FirstFragment>(NavigationRoute.FIRST_SCREEN) {
                deepLink("test://hand_called")
            }
            fragment<SecondFragment>(NavigationRoute.SECOND_SCREEN) {
                deepLink("example://example")
            }

            fragment<ThirdFragment>("details/{itemId}/{itemName}/{user}") {
                label = "Details"
                argument("itemId") {
                    type = NavType.IntType
                    defaultValue = -1
                }
                argument("itemName") {
                    type = NavType.StringType
                    defaultValue = "defaultName"
                }
                argument("user") {
                    type = UserType
                    defaultValue = User("", 0)
                }
            }


            fragment<BottomNavigationFragment>(NavigationRoute.BOTTOM_NAVIGATION)
            fragment<TaskFragment>(NavigationRoute.TASK_SCREEN)
            fragment<FourthFragment>(NavigationRoute.FOURTH_SCREEN)

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("rawr", "$TAG: onViewCreated")

    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.d("rawr", "$TAG: onDestroyView")

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
}