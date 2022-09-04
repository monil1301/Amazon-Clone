package com.shah.amazonclone.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.shah.amazonclone.ui.components.bottombar.AdminBottomBar
import com.shah.amazonclone.ui.navgraph.AdminBottomNavGraph

/**
 * Created by Monil Shah on 05/09/22.
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminRootBottomTabBarScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            AdminBottomBar(navController = navController)
        }
    ) {
        AdminBottomNavGraph(navController = navController)
    }
}
