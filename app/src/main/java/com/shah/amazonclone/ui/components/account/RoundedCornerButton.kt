package com.shah.amazonclone.ui.components.account

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.models.common.getA_ButtonConfig
import com.shah.amazonclone.models.common.getA_TextConfig
import com.shah.amazonclone.ui.components.common.A_Button
import com.shah.amazonclone.ui.theme.LinkWaterBlue
import com.shah.amazonclone.ui.theme.SmokeWhite

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun RoundedCornerButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    A_Button(
        modifier = modifier,
        title = title,
        textConfig = getA_TextConfig(),
        buttonConfig = getA_ButtonConfig(
            shape = RoundedCornerShape(30.dp),
            backgroundColor = SmokeWhite,
            borderStroke = BorderStroke(1.dp, LinkWaterBlue)
        ),
        onClick = onClick
    )
}

@Preview
@Composable
fun PreviewRoundedCornerButton() {
    RoundedCornerButton(title = "Your Orders") {

    }
}
