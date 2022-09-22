package com.shah.amazonclone.ui.screen

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.shah.amazonclone.ui.activities.CategoryProductActivity
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.home.AddressBar
import com.shah.amazonclone.ui.components.home.DealOfTheDayView
import com.shah.amazonclone.ui.components.home.ImageCarousel
import com.shah.amazonclone.ui.components.home.TopCategories
import com.shah.amazonclone.ui.components.topbar.HomeScreenTopBar
import com.shah.amazonclone.utilities.helpers.Constants

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            HomeScreenTopBar()
        }
    ) { paddingValues ->
        A_Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .verticalScroll(state = rememberScrollState()),
        ) {
            AddressBar()
            TopCategories { category ->
                val intent = Intent(context, CategoryProductActivity::class.java)
                intent.putExtra(Constants.BundleKeys.category, category)
                context.startActivity(intent)
            }
            ImageCarousel(Constants.Resources.carouselImages)
            DealOfTheDayView()
        }
    }
}
