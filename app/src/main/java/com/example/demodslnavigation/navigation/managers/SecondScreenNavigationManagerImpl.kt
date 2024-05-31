package com.example.demodslnavigation.navigation.managers

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.presentation.models.NavigationArguments
import com.example.presentation.models.NavigationRoute
import com.example.demodslnavigation.navigation.utils.navigateString
import com.example.presentation.models.User
import com.example.seconscreen.SecondScreenNavigationManager
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SecondScreenNavigationManagerImpl : SecondScreenNavigationManager {
    override fun Fragment.navigateToThirdScreen(
        amount: Int,
        value: String,
        user: User
    ) {

        val userArgument = Uri.encode(Json.encodeToString(user))

        findNavController().navigate("details/${12}/${"itemName"}/${userArgument}")

//        val itemId = 123 // Example itemId
//        findNavController().navigate(NavigationRoute.PROFILE.hashCode(), Bundle().apply {
//            putInt("itemId", itemId)
//        })

//        findNavController().navigate(
//            "${NavigationRoute.PROFILE}?${NavigationArguments.USER_ID}=$value?${NavigationArguments.AMOUNT}=$amount"
////            "${NavigationRoute.PROFILE}?${NavigationArguments.USER_ID}=$value"
//        )

//        findNavController().navigate(
//            navigateString(
//                NavigationRoute.THIRD_SCREEN,
//                NavigationArguments.AMOUNT to amount,
//                NavigationArguments.VALUE to value,
//                NavigationArguments.USER to user
//            )
//        ) {
//
//            // clear stack to first screen
//            popUpTo(NavigationRoute.FIRST_SCREEN) {
//                inclusive = false
//            }
//        }
    }

    override fun Fragment.navigateBack() {
        findNavController().popBackStack()
    }
}