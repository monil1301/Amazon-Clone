package com.shah.amazonclone.models.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
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
    val iconPosition: ViewPosition,
    val icon: ImageVector?,
    val iconDescription: String?,
    val iconPadding: Dp,
    val iconSize: Dp,
    val iconTint: Color,
    val maxLines: Int,
    val overflow: TextOverflow
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
    iconPosition: ViewPosition = ViewPosition.Start,
    icon: ImageVector? = null,
    iconDescription: String? = null,
    iconPadding: Dp = 0.dp,
    iconSize: Dp = 20.dp,
    iconTint: Color = MaterialTheme.colorScheme.onBackground,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
): A_TextConfig = A_TextConfig(
    fontFamily,
    fontSize,
    lineHeight,
    fontWeight,
    textAlign,
    textDecoration,
    color,
    iconPosition,
    icon,
    iconDescription,
    iconPadding,
    iconSize,
    iconTint,
    maxLines,
    overflow
)
