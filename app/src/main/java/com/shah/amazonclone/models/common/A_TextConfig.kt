package com.shah.amazonclone.models.common

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.amazonclone.enums.ViewPosition
import com.shah.amazonclone.ui.theme.OpenSans

/**
 * Created by Monil Shah on 31/08/22.
 */

@Suppress("Classname")
data class A_TextConfig(
    val fontFamily: FontFamily,
    val fontSize: TextUnit,
    val lineHeight: TextUnit,
    val fontWeight: FontWeight,
    val textAlign: TextAlign?,
    val textDecoration: TextDecoration?,
    val color: Color,
    val drawablePosition: ViewPosition,
    @DrawableRes val drawableResource: Int?,
    val drawableDescription: String?,
    val drawablePadding: Dp,
    val drawableSize: Dp,
    val drawableTint: ColorFilter?,
    val maxLines: Int,
)

@Composable
fun getA_TextConfig(
    fontFamily: FontFamily = OpenSans,
    fontSize: TextUnit = 14.sp,
    lineHeight: TextUnit = 21.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign? = null,
    textDecoration: TextDecoration? = null,
    color: Color = Color.Black,
    drawablePosition: ViewPosition = ViewPosition.Start,
    @DrawableRes drawableResource: Int? = null,
    drawableDescription: String? = null,
    drawablePadding: Dp = 0.dp,
    drawableSize: Dp = 20.dp,
    drawableTint: ColorFilter? = null,
    maxLines: Int = Int.MAX_VALUE,
): A_TextConfig = A_TextConfig(
    fontFamily,
    fontSize,
    lineHeight,
    fontWeight,
    textAlign,
    textDecoration,
    color,
    drawablePosition,
    drawableResource,
    drawableDescription,
    drawablePadding,
    drawableSize,
    drawableTint,
    maxLines,
)
