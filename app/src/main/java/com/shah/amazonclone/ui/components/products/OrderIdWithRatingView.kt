package com.shah.amazonclone.ui.components.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.shah.amazonclone.ui.components.common.A_RatingBar
import com.shah.amazonclone.ui.components.common.A_Row

/**
 * Created by Monil Shah on 26/09/22.
 */

@Composable
fun OrderIdWithRatingView(id: String, rating: Float?) {
    A_Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = id,
            style = MaterialTheme.typography.displayMedium,
            color = Color.Gray,
            maxLines = 1
        )

        A_RatingBar(currentRating = rating ?: 0f)
    }
}
