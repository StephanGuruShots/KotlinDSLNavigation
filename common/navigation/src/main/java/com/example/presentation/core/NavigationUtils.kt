package com.example.presentation.core

fun destinationString(route: String, vararg arguments: String): String {
    var dest = route
    arguments.forEach {
        dest += "/$it={$it}"
    }
    return dest
}

fun navigateString(route: String, vararg arguments: Pair<String, Any>): String {
    var dest = route
    arguments.forEach {
        dest += "/${it.first}=${it.second}"
    }
    return dest
}

fun main() {

    val x = "details/itemId=${12}/itemName=${"itemName"}/user=${"userArgument"}"

    val y = navigateString("details", "itemId" to 12, "itemName" to "itemName", "user" to "userArgument")

    println(x)
    println(y)

    val z = "details/itemId={itemId}/itemName={itemName}/user={user}"
    val i = destinationString("details", "itemId", "itemName", "user")

    println(z)
    println(i)
}