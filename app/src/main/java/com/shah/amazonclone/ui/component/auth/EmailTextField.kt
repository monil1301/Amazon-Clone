package com.shah.amazonclone.ui.component.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
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
fun EmailTextField(
    loginDetails: LoginDetails,
    fieldError: LoginFieldError,
    focusManager: FocusManager
) {
    A_OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(id = R.string.email),
        text = loginDetails.email ?: "",
        isError = fieldError.emailEmpty || fieldError.emailInvalid,
        errorMessage = when {
            fieldError.emailEmpty -> stringResource(id = R.string.empty_email)
            fieldError.emailInvalid -> stringResource(id = R.string.invalid_email)
            else -> null
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        ),
        onValueChanged = { updatedEmail ->
            loginDetails.email = updatedEmail
        }
    )
}

