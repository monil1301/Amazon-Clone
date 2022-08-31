package com.shah.amazonclone.utilities.helpers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created by Monil Shah on 01/09/22.
 */

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = Constants.BottomNavBar.Route.home,
        title = Constants.BottomNavBar.Title.home,
        icon = Icons.Outlined.Home
    )

    object Account : BottomBarScreen(
        route = Constants.BottomNavBar.Route.account,
        title = Constants.BottomNavBar.Title.account,
        icon = Icons.Outlined.Person
    )

    object Cart : BottomBarScreen(
        route = Constants.BottomNavBar.Route.cart,
        title = Constants.BottomNavBar.Title.cart,
        icon = Icons.Outlined.ShoppingCart
    )
}
