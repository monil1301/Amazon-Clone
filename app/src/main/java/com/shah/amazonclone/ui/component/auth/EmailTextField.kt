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
import com.shah.amazonclone.models.auth.SignUpDetails
import com.shah.amazonclone.ui.component.common.A_OutlinedTextField
import com.shah.amazonclone.viewmodels.SignUpViewModel

/**
 * Created by Monil Shah on 31/08/22.
 */

@Composable
fun EmailTextField(
    signUpDetails: SignUpDetails,
    signUpViewModel: SignUpViewModel,
    focusManager: FocusManager
) {
    A_OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(id = R.string.email),
        text = signUpDetails.email ?: "",
        isError = signUpViewModel.signUpFieldError.emailEmpty || signUpViewModel.signUpFieldError.emailInvalid,
        errorMessage = when {
            signUpViewModel.signUpFieldError.emailEmpty -> stringResource(id = R.string.empty_email)
            signUpViewModel.signUpFieldError.emailInvalid -> stringResource(id = R.string.invalid_email)
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
            signUpDetails.email = updatedEmail
        }
    )
}

