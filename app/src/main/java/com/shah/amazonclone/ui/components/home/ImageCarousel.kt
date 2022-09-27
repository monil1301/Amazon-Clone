package com.shah.amazonclone.ui.components.home

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_Image
import com.shah.amazonclone.ui.components.common.CirclePageIndicatorView

/**
 * Created by Monil Shah on 04/09/22.
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageCarousel(
    imageUrls: List<String>,
    imageModifier: Modifier = Modifier
        .fillMaxWidth()
        .height(170.dp),
    contentScale: ContentScale = ContentScale.Crop,
    showIndicator: Boolean = false
) {
    val state = rememberPagerState()
    A_Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth(),
            state = state,
            count = imageUrls.size
        ) { index ->
            A_Image(
                modifier = imageModifier,
                url = imageUrls[index],
                contentScale = contentScale
            )
        }

        if (showIndicator) {
            CirclePageIndicatorView(totalCount = imageUrls.size, currentIndex = state.currentPage)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImagesCarousel(imageList: List<Uri>) {
    val state = rememberPagerState()
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp),
        state = state,
        count = imageList.size
    ) { index ->
        A_Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp),
            uri = imageList[index],
            contentScale = ContentScale.Crop
        )
    }
}
