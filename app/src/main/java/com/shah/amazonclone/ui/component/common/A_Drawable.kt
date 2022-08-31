package com.shah.amazonclone.ui.component.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
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
    resource: Int,
    description: String?,
    viewPosition: ViewPosition,
    tint: ColorFilter?,
) {
    Image(
        modifier = Modifier
            .padding(end = if (viewPosition == ViewPosition.Start) padding else 0.dp)
            .padding(start = if (viewPosition == ViewPosition.End) padding else 0.dp)
            .size(size),
        painter = painterResource(id = resource),
        colorFilter = tint,
        contentDescription = description,
    )
}
