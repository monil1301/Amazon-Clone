package com.shah.amazonclone.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.shah.amazonclone.ui.components.bottombar.UserBottomBar
import com.shah.amazonclone.ui.navgraph.UserBottomNavGraph

/**
 * Created by Monil Shah on 01/09/22.
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RootBottomTabBarScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            UserBottomBar(navController = navController)
        }
    ) {
        UserBottomNavGraph(navController = navController)
    }
}
