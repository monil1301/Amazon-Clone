package com.shah.amazonclone.ui.components.common

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
        if (config.icon != null && config.iconPosition == ViewPosition.Start) {
            A_DrawableView(
                config.iconPadding,
                config.iconSize,
                config.icon,
                config.iconDescription,
                config.iconPosition,
                config.iconTint
            )
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
            overflow = config.overflow
        )
        if (config.icon != null && config.iconPosition == ViewPosition.End) {
            A_DrawableView(
                config.iconPadding,
                config.iconSize,
                config.icon,
                config.iconDescription,
                config.iconPosition,
                config.iconTint
            )
        }
    }
}
