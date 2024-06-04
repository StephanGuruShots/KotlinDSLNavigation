package com.example.thirdscreen

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.presentation.core.NavigationRoute
import com.example.presentation.models.User
import com.example.presentation.utils.parcelable
import com.example.thirdscreen.databinding.FragmentThirdBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    @Inject lateinit var navigationManager: ThirdScreenNavigationManager

    val TAG = "ThirdFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(layoutInflater)
        Log.d("rawr","$TAG: onCreateView")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        val amount = arguments?.getInt(NavigationArguments.AMOUNT)
//        val value = arguments?.getString(NavigationArguments.VALUE)
//        val user = arguments?.getParcelable(NavigationArguments.USER, User::class.java)

//        Log.d("rawr","$TAG: onViewCreated: amount: $amount, value: $value, user: $user")

//        val userId = arguments?.getString(NavigationArguments.USER_ID)
//        val amount = arguments?.getString(NavigationArguments.AMOUNT)
//
//        Log.d("rawr","$TAG: onViewCreated: userId: $userId")
//        Log.d("rawr","$TAG: onViewCreated: amount: $amount")

        val itemId = arguments?.getInt("itemId") ?: -1
        val itemName = arguments?.getString("itemName") ?: "defaultName"
        val user = arguments?.parcelable<User>("user")

        Log.d("rawr","$TAG: onViewCreated: itemId: $itemId itemName: $itemName user: $user")

        binding.btnBack.setOnClickListener {
            with(navigationManager) {
                navigateBack()
            }
        }
        Log.d("rawr","$TAG: onViewCreated")

        binding.btnBottomNavigation.setOnClickListener {
            with(navigationManager) {
                navigateToBottomNavigation()
            }
        }

        binding.btnDeeplink.setOnClickListener {
            val deepLinkUri = Uri.parse("test://hand_called")

            findNavController().navigate(deepLinkUri)
        }

        binding.btnFourthScreen.setOnClickListener {
            val navController = findNavController()
            navController.navigate(NavigationRoute.FOURTH_SCREEN) {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("rawr","$TAG: onDestroy")

    }

    override fun onPause() {
        super.onPause()

        Log.d("rawr","$TAG: onPause")

    }

    override fun onStart() {
        super.onStart()

        Log.d("rawr","$TAG: onStart")

    }

    override fun onStop() {
        super.onStop()

        Log.d("rawr","$TAG: onStop")

    }

    override fun onResume() {
        super.onResume()

        Log.d("rawr","$TAG: onResume")

    }
}