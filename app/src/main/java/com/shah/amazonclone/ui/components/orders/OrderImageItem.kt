package com.shah.amazonclone.ui.components.orders

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.ui.components.common.A_Image

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun OrderImageItem(url: String) {
    Box(
        modifier = Modifier
            .border(
                width = Dp.Hairline,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        A_Image(
            modifier = Modifier
                .size(150.dp)
                .clip(shape = RoundedCornerShape(12.dp)),
            url = url
        )
    }
}
