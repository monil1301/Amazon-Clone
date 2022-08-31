package com.shah.amazonclone.ui.component.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.shah.amazonclone.R
import com.shah.amazonclone.models.auth.LoginDetails
import com.shah.amazonclone.models.auth.LoginFieldError
import com.shah.amazonclone.ui.component.common.A_OutlinedTextField

/**
 * Created by Monil Shah on 31/08/22.
 */

@Composable
fun PasswordTextField(
    loginDetails: LoginDetails,
    fieldError: LoginFieldError,
    focusManager: FocusManager,
    onDoneClick: () -> Unit = {}
) {
    A_OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(id = R.string.password),
        text = loginDetails.password ?: "",
        isError = fieldError.passwordEmpty || fieldError.passwordLength,
        errorMessage = when {
            fieldError.passwordEmpty -> stringResource(id = R.string.empty_password)
            fieldError.passwordLength -> stringResource(id = R.string.password_minimum_characters)
            else -> null
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                onDoneClick()
            }
        ),
        onValueChanged = { updatedPassword ->
            loginDetails.password = updatedPassword
        }
    )
}
