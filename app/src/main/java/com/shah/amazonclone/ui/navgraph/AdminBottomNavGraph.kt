package com.shah.amazonclone.ui.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shah.amazonclone.ui.screen.AdminHomeScreen
import com.shah.amazonclone.ui.screen.AnalyticsScreen
import com.shah.amazonclone.ui.screen.OrdersScreen
import com.shah.amazonclone.utilities.helpers.BottomBarScreen

/**
 * Created by Monil Shah on 05/09/22.
 */

@Composable
fun AdminBottomNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            AdminHomeScreen()
        }

        composable(route = BottomBarScreen.Analytics.route) {
            AnalyticsScreen()
        }

        composable(route = BottomBarScreen.Orders.route) {
            OrdersScreen()
        }
    }
}

