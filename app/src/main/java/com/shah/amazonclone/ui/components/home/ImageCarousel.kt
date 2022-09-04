package com.shah.amazonclone.ui.components.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.shah.amazonclone.ui.components.common.A_Image
import com.shah.amazonclone.utilities.helpers.Constants

/**
 * Created by Monil Shah on 04/09/22.
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageCarousel() {
    val state = rememberPagerState()
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp),
        state = state,
        count = Constants.Resources.carouselImages.size
    ) { index ->
        A_Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp),
            url = Constants.Resources.carouselImages[index],
            contentScale = ContentScale.Crop
        )
    }
}
