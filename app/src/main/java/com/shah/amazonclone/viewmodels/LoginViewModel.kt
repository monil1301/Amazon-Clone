package com.shah.amazonclone.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.models.auth.LoginDetails
import com.shah.amazonclone.models.auth.LoginFieldError
import com.shah.amazonclone.network.LoginApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.LoginRepository
import com.shah.amazonclone.utilities.helpers.Constants
import com.shah.amazonclone.utilities.helpers.logD
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 31/08/22.
 */
class LoginViewModel: ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        LoginRepository(apiBuilder.buildApi(LoginApi::class.java))

    // Public variables
    var loginFieldError by mutableStateOf(LoginFieldError())

    // API Calls
    fun login(loginDetails: LoginDetails, onResponse: (Boolean, String) -> Unit) =
        viewModelScope.launch {
            when (val response = repository.login(loginDetails)) {
                is ResponseResource.Failure -> {
                    logD(message = "Login failed")
                    onResponse(false, response.errorMessage ?: "Login failed")
                }
                is ResponseResource.Success -> {
                    logD(message = "Successful Login")
                    onResponse(true, "Successful Login")
                }
            }
        }

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