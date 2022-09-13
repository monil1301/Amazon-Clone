package com.shah.amazonclone.ui.components.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.enums.ViewPosition

/**
 * Created by Monil Shah on 31/08/22.
 */

@Composable
fun A_DrawableView(
    padding: Dp,
    size: Dp,
    resource: ImageVector,
    description: String?,
    viewPosition: ViewPosition,
    tint: Color,
) {
    Icon(
        modifier = Modifier
            .padding(end = if (viewPosition == ViewPosition.Start) padding else 0.dp)
            .padding(start = if (viewPosition == ViewPosition.End) padding else 0.dp)
            .size(size),
        imageVector = resource,
        tint = tint,
        contentDescription = description,
    )
}
