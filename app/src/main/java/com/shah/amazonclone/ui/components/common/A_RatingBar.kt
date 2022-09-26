package com.shah.amazonclone.ui.components.common

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.enums.RatingStarStatus
import com.shah.amazonclone.utilities.helpers.Constants

/**
 * Created by Monil Shah on 24/09/22.
 */

@Composable
fun A_RatingBar(
    modifier: Modifier = Modifier,
    range: IntRange = 1..Constants.Size.ratingRange,
    isLargeRating: Boolean = false,
    currentRating: Float,
) {
    val halfStarRange = (0.5f)..(0.9f)

    LazyRow(
        modifier = modifier
    ) {
        items(items = range.toList()) { index ->
            val ratingStarStatus = when {
                (index <= currentRating) -> RatingStarStatus.SELECTED
                ((index - currentRating) in halfStarRange) -> RatingStarStatus.HALF_SELECTED
                else -> RatingStarStatus.NOT_SELECTED
            }
            A_RatingItem(
                ratingStarStatus = ratingStarStatus,
                padding = if (isLargeRating) 2.dp else 0.dp,
                size = if (isLargeRating) 32.dp else 18.dp
            )
        }
    }
}

@Composable
@Preview
fun PreviewVV_RatingBar() {
    A_Row {
        A_RatingBar(
            range = 1..Constants.Size.ratingRange,
            currentRating = 5f
        )
    }
}