package com.shah.amazonclone.ui.components.bottombar

import androidx.compose.material.BottomNavigation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shah.amazonclone.utilities.helpers.BottomBarScreen
import com.shah.amazonclone.utilities.helpers.FlowEvents
import com.shah.amazonclone.utilities.helpers.UserHelper
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun UserBottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Account,
        BottomBarScreen.Cart
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var cart by remember {
        mutableStateOf(UserHelper.user?.cart)
    }

    LaunchedEffect(key1 = Unit) {
        launch {
            FlowEvents.userCart.collect {
                cart = it
            }
        }
    }

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        screens.forEach { screen ->
            BottomBarItem(
                screen = screen,
                badgeCount = if (screen == BottomBarScreen.Cart) cart?.size ?: 0 else 0,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}
