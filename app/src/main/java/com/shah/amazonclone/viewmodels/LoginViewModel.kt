package com.shah.amazonclone.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.shah.amazonclone.models.auth.LoginDetails
import com.shah.amazonclone.models.auth.LoginFieldError
import com.shah.amazonclone.utilities.helpers.Constants

/**
 * Created by Monil Shah on 31/08/22.
 */
class LoginViewModel: ViewModel() {

    // Public variables
    var loginFieldError by mutableStateOf(LoginFieldError())

    // Validation Methods
    fun validateLoginDetails(loginDetails: LoginDetails): Boolean {
        var isValid = true
        val loginErrors = LoginFieldError()

        if (loginDetails.password.isNullOrBlank()) {
            isValid = false
            loginErrors.passwordEmpty = true
        } else if ((loginDetails.password?.length ?: 0) < Constants.Size.passwordMinimumLength) {
            isValid = false
            loginErrors.passwordLength = true
        }

        if (loginDetails.email.isNullOrBlank()) {
            isValid = false
            loginErrors.emailEmpty = true
        } else if (loginDetails.email?.matches(Constants.Validation.emailPattern.toRegex()) == false) {
            isValid = false
            loginErrors.emailInvalid = true
        }

        loginFieldError = loginErrors
        return isValid
    }
}