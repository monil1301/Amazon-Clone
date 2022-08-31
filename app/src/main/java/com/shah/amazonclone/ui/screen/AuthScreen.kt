package com.shah.amazonclone.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.enums.AuthState
import com.shah.amazonclone.models.auth.LoginDetails
import com.shah.amazonclone.models.auth.SignUpDetails
import com.shah.amazonclone.ui.component.auth.LoginView
import com.shah.amazonclone.ui.component.auth.SignUpView
import com.shah.amazonclone.ui.component.common.A_Column
import com.shah.amazonclone.ui.component.common.A_RadioButton
import com.shah.amazonclone.ui.theme.DarkGray

@Composable
fun AuthScreen() {

    var authState by remember { mutableStateOf(AuthState.LOGIN) }

    A_Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        A_Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = if (authState == AuthState.LOGIN) MaterialTheme.colorScheme.background else DarkGray)
                .border(width = 1.dp, color = MaterialTheme.colorScheme.outline)
                .padding(8.dp)
        ) {
            A_RadioButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 8.dp),
                isSelected = authState == AuthState.LOGIN,
                text = stringResource(id = R.string.login)
            ) {
                authState = AuthState.LOGIN
            }

            if (authState == AuthState.LOGIN) {
                LoginView(
                    modifier = Modifier
                        .fillMaxWidth(),
                    loginDetails = LoginDetails()
                )
            }
        }

        A_Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = if (authState == AuthState.SIGN_UP) MaterialTheme.colorScheme.background else DarkGray)
                .border(width = 1.dp, color = MaterialTheme.colorScheme.outline)
                .padding(8.dp)
        ) {
            A_RadioButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 8.dp),
                isSelected = authState == AuthState.SIGN_UP,
                text = stringResource(id = R.string.sign_up)
            ) {
                authState = AuthState.SIGN_UP
            }

            if (authState == AuthState.SIGN_UP) {
                SignUpView(
                    modifier = Modifier
                        .fillMaxWidth(),
                    signUpDetails = SignUpDetails()
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewAuthScreen() {
    AuthScreen()
}