package com.shah.amazonclone.ui.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R

/**
 * Created by Monil Shah on 28/08/22.
 */

@Composable
fun A_OutlinedTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: String = "",
    textStyle: TextStyle = MaterialTheme.typography.displayMedium,
    singleLine: Boolean = true,
    maxCharacterLength: Int? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    isError: Boolean = false,
    errorMessage: String? = null,
    isReadOnly: Boolean = false,
    isEnabled: Boolean = true,
    onValueChanged: (String) -> Unit,
) {
    var textValue by remember { mutableStateOf(text) }

    A_Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = if (isEnabled) textValue else text,
            textStyle = textStyle,
            label = {
                Text(text = label)
            },
            onValueChange = { newTextValue ->
                textValue = if (maxCharacterLength != null) {
                    newTextValue.take(maxCharacterLength)
                } else {
                    newTextValue
                }

                onValueChanged(textValue.trim())
            },
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
