package com.shah.amazonclone.ui.component.common

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.enums.ButtonElevation
import com.shah.amazonclone.enums.ViewPosition
import com.shah.amazonclone.models.common.A_ButtonConfig
import com.shah.amazonclone.models.common.A_TextConfig
import com.shah.amazonclone.models.common.getA_ButtonConfig
import com.shah.amazonclone.models.common.getA_TextConfig
import com.shah.amazonclone.ui.theme.OpenSans

/**
 * Created by Monil Shah on 31/08/22.
 */

@Composable
fun A_Button(
    modifier: Modifier,
    title: String,
    textConfig: A_TextConfig = getA_TextConfig(
        color = MaterialTheme.colorScheme.onSecondary,
        fontWeight = FontWeight.Bold,
        fontSize = MaterialTheme.typography.displayMedium.fontSize,
        fontFamily = OpenSans
    ),
    buttonConfig: A_ButtonConfig = getA_ButtonConfig(),
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = buttonConfig.shape,
        border = buttonConfig.borderStroke,
        enabled = buttonConfig.isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonConfig.backgroundColor,
            disabledContainerColor = Color.Gray
        ),
        onClick = { onClick() },
        contentPadding = buttonConfig.contentPadding,
        elevation = if (buttonConfig.elevation == ButtonElevation.NONE) null else ButtonDefaults.buttonElevation(),
    ) {
        Box {
            A_Row {
                if (buttonConfig.icon != null && buttonConfig.iconPosition == ViewPosition.Start) {
                    Icon(
                        painter = painterResource(id = buttonConfig.icon),
                        contentDescription = title,
                        tint = textConfig.color
                    )
                    Spacer(modifier = Modifier.width(buttonConfig.iconPadding))
                }

                A_Text(
                    text = title,
                    config = textConfig
                )

                if (buttonConfig.icon != null && buttonConfig.iconPosition == ViewPosition.End) {
                    Spacer(modifier = Modifier.width(buttonConfig.iconPadding))
                    Icon(painter = painterResource(id = buttonConfig.icon),
                        contentDescription = title,
                        tint = textConfig.color)
                }
            }

            if (buttonConfig.shouldShowLoader) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewButton() {
    A_Button(
        modifier = Modifier
            .padding(end = 12.dp)
            .fillMaxWidth()
            .wrapContentWidth(Alignment.End),
        title = stringResource(id = com.shah.amazonclone.R.string.login),
    ) {}
}
