package com.shah.amazonclone.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.ui.screen.RootBottomTabBarScreen
import com.shah.amazonclone.ui.theme.AmazonCloneTheme
import com.shah.amazonclone.utilities.helpers.UserHelper

class RootBottomTabBarActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        UserHelper.getUserDetails(application as AmazonCloneApplication)
        setContent {
            AmazonCloneTheme {
                RootBottomTabBarScreen()
            }
        }
    }
}
