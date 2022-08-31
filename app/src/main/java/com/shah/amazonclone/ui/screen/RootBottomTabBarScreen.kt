package com.shah.amazonclone.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.shah.amazonclone.ui.components.bottombar.BottomBar
import com.shah.amazonclone.ui.navgraph.BottomNavGraph

/**
 * Created by Monil Shah on 01/09/22.
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RootBottomTabBarScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}
