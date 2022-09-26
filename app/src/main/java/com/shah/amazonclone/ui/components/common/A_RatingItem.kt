package com.shah.amazonclone.ui.components.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.enums.RatingStarStatus

/**
 * Created by Monil Shah on 24/09/22.
 */

@Composable
fun A_RatingItem(
    ratingStarStatus: RatingStarStatus,
    padding: Dp = 0.dp,
    size: Dp = 18.dp,
) {
    Icon(
        modifier = Modifier
            .size(size)
            .padding(padding),
        imageVector = when (ratingStarStatus) {
            RatingStarStatus.NOT_SELECTED -> Icons.Default.StarOutline
            RatingStarStatus.SELECTED -> Icons.Default.Star
            RatingStarStatus.HALF_SELECTED -> Icons.Default.StarHalf
        },
        contentDescription = "Rating Star",
        tint = MaterialTheme.colorScheme.secondary
    )
}

@Composable
@Preview
fun PreviewRating() {
    A_RatingItem(
        ratingStarStatus = RatingStarStatus.SELECTED,
        padding = 2.dp,
        size = 32.dp
    )
}
