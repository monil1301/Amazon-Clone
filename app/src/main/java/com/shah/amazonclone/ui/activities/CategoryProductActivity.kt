package com.shah.amazonclone.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shah.amazonclone.ui.screen.CategoryProductScreen
import com.shah.amazonclone.ui.theme.AmazonCloneTheme
import com.shah.amazonclone.utilities.helpers.Constants

/**
 * Created by Monil Shah on 23/09/22.
 */

class CategoryProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmazonCloneTheme {
                intent.getStringExtra(Constants.BundleKeys.category)?.let { category ->
                    CategoryProductScreen(category = category) {
                        onBackPressed()
                    }
                }
            }
        }
    }
}
