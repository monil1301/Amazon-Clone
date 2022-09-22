package com.shah.amazonclone.utilities.helpers

/**
 * Created by Monil Shah on 17/09/22.
 */

sealed class Screen(
    val route: String,
    val title: String,
) {
    object Home : Screen(
        route = Constants.Screen.Route.home,
        title = Constants.Screen.Title.home
    )

    object Category : Screen(
        route = Constants.Screen.Route.category,
        title = Constants.Screen.Title.category
    )
}
