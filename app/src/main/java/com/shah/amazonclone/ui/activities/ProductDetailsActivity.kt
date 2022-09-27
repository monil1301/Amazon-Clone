package com.shah.amazonclone.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.ui.screen.ProductDetailsScreen
import com.shah.amazonclone.ui.theme.AmazonCloneTheme
import com.shah.amazonclone.utilities.helpers.Constants

/**
 * Created by Monil Shah on 26/09/22.
 */
class ProductDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmazonCloneTheme {
                intent.getParcelableExtra<Product>(Constants.BundleKeys.product)?.let { product ->
                    ProductDetailsScreen(product = product) {
                        onBackPressed()
                    }
                }
            }
        }
    }
}
