package com.shah.amazonclone.ui.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.ui.theme.CapeCodGray

/**
 * Created by Monil Shah on 28/08/22.
 */

@Composable
fun A_OutlinedTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: String = "",
    shouldShouldLabel: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.displayMedium,
    startIcon: ImageVector? = null,
    endIcon: ImageVector? = null,
    iconDescription: String? = null,
    singleLine: Boolean = true,
    maxCharacterLength: Int? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    isError: Boolean = false,
    errorMessage: String? = null,
    isReadOnly: Boolean = false,
    isEnabled: Boolean = true,
    fieldHeight: Dp? = null,
    onValueChanged: (String) -> Unit,
) {
    var textValue by remember { mutableStateOf(text) }

    val leadingIcon: @Composable (() -> Unit)? = if (startIcon != null) {
        {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = startIcon,
                contentDescription = iconDescription
            )
        }
    } else null

    val trailingIcon: @Composable (() -> Unit)? = if (endIcon != null) {
        {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = endIcon,
                contentDescription = iconDescription
            )
        }
    } else null

    val textFieldLabel: @Composable (() -> Unit)? = if (shouldShouldLabel) {
        {
            Text(text = label)
        }
    } else null

    val placeholder: @Composable (() -> Unit)? = if (!shouldShouldLabel) {
        {
            Text(text = label, style = textStyle)
        }
    } else null

    A_Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        val fieldModifier = Modifier.fillMaxWidth()
        OutlinedTextField(
            modifier = if (fieldHeight != null) {
                fieldModifier.height(fieldHeight)
            } else fieldModifier,
            value = if (isEnabled) textValue else text,
            textStyle = textStyle,
            label = textFieldLabel,
            placeholder = placeholder,
            onValueChange = { newTextValue ->
                textValue = if (maxCharacterLength != null) {
                    newTextValue.take(maxCharacterLength)
                } else {
                    newTextValue
                }

                onValueChanged(textValue.trim())
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = isError,
            singleLine = singleLine,
            readOnly = isReadOnly,
            enabled = isEnabled,
            shape = RoundedCornerShape(4.dp),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                errorBorderColor = MaterialTheme.colorScheme.error,
                errorLabelColor = MaterialTheme.colorScheme.error,
                errorCursorColor = MaterialTheme.colorScheme.error,
                disabledBorderColor = CapeCodGray,
                disabledLabelColor = CapeCodGray,
                disabledTextColor = CapeCodGray
            ),
        )

        if (isError && errorMessage != null) {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewA_LabelledTextField() {
    A_OutlinedTextField(label = stringResource(id = R.string.email)) {}
}
