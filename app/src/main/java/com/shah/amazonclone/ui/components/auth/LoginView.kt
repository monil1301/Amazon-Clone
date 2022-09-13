package com.shah.amazonclone.ui.components.auth

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.amazonclone.R
import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.models.auth.LoginDetails
import com.shah.amazonclone.models.common.getA_ButtonConfig
import com.shah.amazonclone.models.common.getA_TextConfig
import com.shah.amazonclone.ui.activities.RootBottomTabBarActivity
import com.shah.amazonclone.ui.components.common.A_Button
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.theme.AmazonCloneTheme
import com.shah.amazonclone.ui.theme.OpenSans
import com.shah.amazonclone.utilities.utils.startActivityAndFinishCurrent
import com.shah.amazonclone.viewmodels.LoginViewModel

/**
 * Created by Monil Shah on 31/08/22.
 */

@Composable
fun LoginView(
    modifier: Modifier = Modifier,
    loginDetails: LoginDetails
) {
    val focusManager = LocalFocusManager.current
    var isAuthenticating by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val application by lazy { context.applicationContext as AmazonCloneApplication }
    val loginViewModel = remember { LoginViewModel(application) }

    fun onLoginButtonClicked() {
        val isLoginDetailsValid = loginViewModel.validateLoginDetails(loginDetails)

        if (isLoginDetailsValid) {
            isAuthenticating = true

            loginViewModel.login(loginDetails) { isSuccess, errorMessage ->
                isAuthenticating = false

                if (isSuccess) {
                    context.startActivityAndFinishCurrent(
                        Intent(
                            context,
                            RootBottomTabBarActivity::class.java
                        )
                    )
                }

                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    A_Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        EmailTextField(loginDetails, loginViewModel.loginFieldError, focusManager)

        PasswordTextField(loginDetails, loginViewModel.loginFieldError, focusManager) {
            onLoginButtonClicked()
        }

        A_Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            title = stringResource(id = R.string.login),
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
        ) { onLoginButtonClicked() }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginView() {
    AmazonCloneTheme {
        LoginView(modifier = Modifier.padding(8.dp), LoginDetails())
    }
}
