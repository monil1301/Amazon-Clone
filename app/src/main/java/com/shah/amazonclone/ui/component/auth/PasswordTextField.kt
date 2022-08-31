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
import com.shah.amazonclone.models.auth.SignUpDetails
import com.shah.amazonclone.ui.component.common.A_OutlinedTextField
import com.shah.amazonclone.viewmodels.SignUpViewModel

/**
 * Created by Monil Shah on 31/08/22.
 */

@Composable
fun PasswordTextField(
    signUpDetails: SignUpDetails,
    signUpViewModel: SignUpViewModel,
    focusManager: FocusManager,
    onDoneClick: () -> Unit = {}
) {
    A_OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(id = R.string.password),
        text = signUpDetails.password ?: "",
        isError = signUpViewModel.signUpFieldError.passwordEmpty || signUpViewModel.signUpFieldError.passwordLength,
        errorMessage = when {
            signUpViewModel.signUpFieldError.passwordEmpty -> stringResource(id = R.string.empty_password)
            signUpViewModel.signUpFieldError.passwordLength -> stringResource(id = R.string.password_minimum_characters)
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
            signUpDetails.password = updatedPassword
        }
    )
}
