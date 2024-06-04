package com.example.presentation.navExt

import android.net.Uri
import androidx.navigation.NavController
import com.example.presentation.core.NavigationArguments
import com.example.presentation.core.NavigationRoute
import com.example.presentation.core.destinationString
import com.example.presentation.core.navigateString
import com.example.presentation.models.User
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun NavController.navigateToSecondScreen() {
    navigate(NavigationRoute.SECOND_SCREEN)
}

fun NavController.navigateToTaskScreen() {
    navigate(NavigationRoute.TASK_SCREEN)
}

fun NavController.navigateToThirdScreen(
    amount: Int,
    value: String,
    user: User
) {
    val userArgument = Uri.encode(Json.encodeToString(user))
    navigate(
        navigateString(
            NavigationRoute.THIRD_SCREEN,
            NavigationArguments.ITEM_ID to amount,
            NavigationArguments.ITEM_NAME to value,
            NavigationArguments.USER to userArgument
        )
    )
}

fun NavController.navigateToBottomNavigation() {
    navigate(NavigationRoute.BOTTOM_NAVIGATION)
}

fun NavController.navigateToProductDeepLink(user: User) {
    val userArgs = Uri.encode(Json.encodeToString(user))
    val deepLinkUri = Uri.parse("https://www.example.com/product/${userArgs}")

    navigate(deepLinkUri)
}

fun NavController.navigateToHandmadeDeepLink() {
    val deepLinkUri = Uri.parse("test://hand_called")

    navigate(deepLinkUri)
}

fun NavController.navigateToForthScreen() {

    val userArgs = Uri.encode(Json.encodeToString(User("123", 1)))

    navigate(navigateString(NavigationRoute.FOURTH_SCREEN, NavigationArguments.USER to userArgs)) {
        popUpTo(this@navigateToForthScreen.graph.startDestinationId) {
            inclusive = true
        }
    }
}


