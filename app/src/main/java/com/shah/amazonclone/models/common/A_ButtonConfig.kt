package com.shah.amazonclone.models.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.enums.ButtonElevation
import com.shah.amazonclone.enums.ViewPosition

/**
 * Created by Monil Shah on 31/08/22.
 */

@Suppress("ClassName")
data class A_ButtonConfig(
    val backgroundColor: Color,
    val shape: Shape,
    @DrawableRes val icon: Int?,
    val iconPosition: ViewPosition,
    val iconPadding: Dp,
    val contentPadding: PaddingValues,
    val elevation: ButtonElevation,
    val borderStroke: BorderStroke?,
    val isEnabled: Boolean,
    val shouldShowLoader: Boolean,
)

@Composable
fun getA_ButtonConfig(
    backgroundColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    shape: Shape = RoundedCornerShape(4.dp),
    @DrawableRes icon: Int? = null,
    iconPosition: ViewPosition = ViewPosition.Start,
    iconPadding: Dp = 8.dp,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    elevation: ButtonElevation = ButtonElevation.DEFAULT,
    borderStroke: BorderStroke? = null,
    isEnabled: Boolean = true,
    shouldShowLoader: Boolean = false,
): A_ButtonConfig = A_ButtonConfig(
    backgroundColor,
    shape,
    icon,
    iconPosition,
    iconPadding,
    contentPadding,
    elevation,
    borderStroke,
    isEnabled,
    shouldShowLoader
)
