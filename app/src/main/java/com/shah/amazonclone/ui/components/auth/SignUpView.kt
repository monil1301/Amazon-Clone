package com.shah.amazonclone.ui.components.auth

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.amazonclone.R
import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.models.auth.SignUpDetails
import com.shah.amazonclone.models.common.getA_ButtonConfig
import com.shah.amazonclone.models.common.getA_TextConfig
import com.shah.amazonclone.ui.activities.MainActivity
import com.shah.amazonclone.ui.components.common.A_Button
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_OutlinedTextField
import com.shah.amazonclone.ui.theme.AmazonCloneTheme
import com.shah.amazonclone.ui.theme.OpenSans
import com.shah.amazonclone.utilities.helpers.startActivityAndFinishCurrent
import com.shah.amazonclone.viewmodels.SignUpViewModel

/**
 * Created by Monil Shah on 03/07/22.
 */

@Composable
fun SignUpView(
    modifier: Modifier = Modifier,
    signUpDetails: SignUpDetails
) {
    val focusManager = LocalFocusManager.current
    var isAuthenticating by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val application by lazy { context.applicationContext as AmazonCloneApplication }
    val signUpViewModel = remember { SignUpViewModel(application) }

    fun onSignUpButtonClicked() {
        val isSignUpDetailsValid = signUpViewModel.validateSignUpDetails(signUpDetails)

        if (isSignUpDetailsValid) {
            isAuthenticating = true

            signUpViewModel.signUp(signUpDetails) { isSuccess, errorMessage ->
                isAuthenticating = false

                if (isSuccess) {
                    context.startActivityAndFinishCurrent(Intent(context, MainActivity::class.java))
                }

                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    A_Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        NameTextField(signUpDetails, signUpViewModel, focusManager)

        EmailTextField(signUpDetails, signUpViewModel.signUpFieldError, focusManager)

        PasswordTextField(signUpDetails, signUpViewModel.signUpFieldError, focusManager) {
            onSignUpButtonClicked()
        }

        A_Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            title = stringResource(id = R.string.sign_up),
            textConfig = getA_TextConfig(
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                fontFamily = OpenSans
            ),
            buttonConfig = getA_ButtonConfig(
                isEnabled = !isAuthenticating,
                contentPadding = PaddingValues(vertical = 14.dp),
                shouldShowLoader = isAuthenticating
            )
        ) { onSignUpButtonClicked() }
    }
}

@Composable
private fun NameTextField(
    signUpDetails: SignUpDetails,
    signUpViewModel: SignUpViewModel,
    focusManager: FocusManager
) {
    A_OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(id = R.string.name),
        text = signUpDetails.name ?: "",
        isError = signUpViewModel.signUpFieldError.nameEmpty || signUpViewModel.signUpFieldError.nameMinLength,
        errorMessage = when {
            signUpViewModel.signUpFieldError.nameEmpty -> stringResource(id = R.string.mandatory_name)
            signUpViewModel.signUpFieldError.nameMinLength -> stringResource(id = R.string.name_minimum_characters)
            else -> null
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        ),
        onValueChanged = { updatedName ->
            signUpDetails.name = updatedName
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpView() {
    AmazonCloneTheme {
        SignUpView(modifier = Modifier.padding(8.dp), SignUpDetails())
    }
}
