package com.shah.amazonclone.ui.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.shah.amazonclone.ui.components.topbar.HomeScreenTopBar

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeScreenTopBar()
        }
    ) {

    }
}
