package com.shah.amazonclone.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.shah.amazonclone.utilities.helpers.Constants
import com.shah.amazonclone.models.auth.SignUpDetails
import com.shah.amazonclone.models.auth.SignUpFieldError

/**
 * Created by Monil Shah on 06/08/22.
 */

class SignUpViewModel: ViewModel() {

    // Public variables
    var signUpFieldError by mutableStateOf(SignUpFieldError())

    // Validation Methods
    fun validateSignUpDetails(signUpDetails: SignUpDetails): Boolean {
        var isValid = true
        val signUpErrors = SignUpFieldError()
        if (signUpDetails.name.isNullOrBlank()) {
            isValid = false
            signUpErrors.nameEmpty = true
        } else if ((signUpDetails.name?.length ?: 0) < Constants.Size.userNameMinimumLength) {
            isValid = false
            signUpErrors.nameMinLength = true
        }

        if (signUpDetails.password.isNullOrBlank()) {
            isValid = false
            signUpErrors.passwordEmpty = true
        } else if ((signUpDetails.password?.length ?: 0) < Constants.Size.passwordMinimumLength) {
            isValid = false
            signUpErrors.passwordLength = true
        }

        if (signUpDetails.email.isNullOrBlank()) {
            isValid = false
            signUpErrors.emailEmpty = true
        } else if (signUpDetails.email?.matches(Constants.Validation.emailPattern.toRegex()) == false) {
            isValid = false
            signUpErrors.emailInvalid = true
        }

        signUpFieldError = signUpErrors
        return isValid
    }

}