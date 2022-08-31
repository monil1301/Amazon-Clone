package com.shah.amazonclone.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shah.amazonclone.ui.screen.RootBottomTabBarScreen
import com.shah.amazonclone.ui.theme.AmazonCloneTheme

class RootBottomTabBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmazonCloneTheme {
                RootBottomTabBarScreen()
            }
        }
    }
}
