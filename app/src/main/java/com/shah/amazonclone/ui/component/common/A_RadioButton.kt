package com.shah.amazonclone.ui.component.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.RadioButtonChecked
import androidx.compose.material.icons.outlined.RadioButtonUnchecked
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R

/**
 * Created by Monil Shah on 31/08/22.
 */

@Composable
fun A_RadioButton(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    text: String,
    onSelected: () -> Unit
) {
    A_Row(
        modifier = modifier
            .clickable {
                onSelected()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = if (isSelected) Icons.Outlined.RadioButtonChecked else Icons.Outlined.RadioButtonUnchecked,
            contentDescription = "Radio Button"
        )

        A_Text(text = text)
    }
}

@Preview
@Composable
fun PreviewRadioButton() {
    A_RadioButton(isSelected = false, text = stringResource(id = R.string.login), onSelected = {})
}
