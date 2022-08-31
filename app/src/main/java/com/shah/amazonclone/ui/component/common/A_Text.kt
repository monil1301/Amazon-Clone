package com.shah.amazonclone.ui.component.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shah.amazonclone.enums.ViewPosition
import com.shah.amazonclone.models.common.A_TextConfig
import com.shah.amazonclone.models.common.getA_TextConfig

/**
 * Created by Monil Shah on 31/08/22.
 */

@Composable
fun A_Text(
    modifier: Modifier = Modifier,
    text: String,
    config: A_TextConfig = getA_TextConfig(),
) {
    A_Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (config.drawableResource != null && config.drawablePosition == ViewPosition.Start) {
            A_DrawableView(config.drawablePadding,
                config.drawableSize,
                config.drawableResource,
                config.drawableDescription,
                config.drawablePosition,
                config.drawableTint)
        }
        Text(
            text = text,
            fontFamily = config.fontFamily,
            fontSize = config.fontSize,
            lineHeight = config.lineHeight,
            fontWeight = config.fontWeight,
            textAlign = config.textAlign,
            color = config.color,
            textDecoration = config.textDecoration,
            maxLines = config.maxLines,
        )
        if (config.drawableResource != null && config.drawablePosition == ViewPosition.End) {
            A_DrawableView(config.drawablePadding,
                config.drawableSize,
                config.drawableResource,
                config.drawableDescription,
                config.drawablePosition,
                config.drawableTint)
        }
    }
}
