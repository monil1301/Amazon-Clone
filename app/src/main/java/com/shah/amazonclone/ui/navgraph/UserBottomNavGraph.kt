package com.shah.amazonclone.ui.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shah.amazonclone.ui.screen.AccountScreen
import com.shah.amazonclone.ui.screen.CartScreen
import com.shah.amazonclone.ui.screen.HomeScreen
import com.shah.amazonclone.utilities.helpers.BottomBarScreen

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun UserBottomNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }

        composable(route = BottomBarScreen.Account.route) {
            AccountScreen()
        }

        composable(route = BottomBarScreen.Cart.route) {
            CartScreen()
        }
    }
}
