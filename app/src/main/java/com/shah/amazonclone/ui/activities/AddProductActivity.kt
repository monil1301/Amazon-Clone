package com.shah.amazonclone.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shah.amazonclone.ui.screen.AddProductScreen
import com.shah.amazonclone.ui.theme.AmazonCloneTheme

/**
 * Created by Monil Shah on 06/09/22.
 */
class AddProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmazonCloneTheme {
                AddProductScreen {
                    onBackPressed()
                }
            }
        }
    }
}
