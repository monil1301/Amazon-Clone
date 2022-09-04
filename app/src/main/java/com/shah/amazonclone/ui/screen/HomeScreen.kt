package com.shah.amazonclone.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.home.AddressBar
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
    ) { paddingValues ->
        A_Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            AddressBar()
        }
    }
}
