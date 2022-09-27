package com.shah.amazonclone.ui.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

/**
 * Created by Monil Shah on 26/09/22.
 */

@Composable
fun CirclePageIndicatorView(
    totalCount: Int,
    currentIndex: Int,
) {
    A_Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(totalCount) { index ->
            Card(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape),
                shape = CircleShape,
                backgroundColor = if (index == currentIndex) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.outline
            ) {}
        }
    }
}
