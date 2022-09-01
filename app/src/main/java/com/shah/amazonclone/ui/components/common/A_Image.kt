package com.shah.amazonclone.ui.components.common

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun A_Image(
    modifier: Modifier = Modifier,
    url: String?,
    shimmerParams: ShimmerParams = ShimmerParams(
        baseColor = MaterialTheme.colors.background,
        highlightColor = Color.Gray
    ),
    contentScale: ContentScale = ContentScale.Fit,
    error: Any? = null,
) {
    GlideImage(
        modifier = modifier,
        imageModel = url ?: "",
        shimmerParams = shimmerParams,
        contentScale = contentScale,
        error = error,
    )
}
