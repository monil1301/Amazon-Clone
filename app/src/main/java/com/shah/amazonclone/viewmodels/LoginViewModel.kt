package com.shah.amazonclone.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.models.auth.LoginDetails
import com.shah.amazonclone.models.auth.LoginFieldError
import com.shah.amazonclone.network.LoginApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.LoginRepository
import com.shah.amazonclone.utilities.helpers.Constants
import com.shah.amazonclone.utilities.utils.ifLet
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 31/08/22.
 */
class LoginViewModel(application: AmazonCloneApplication) : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        LoginRepository(apiBuilder.buildApi(LoginApi::class.java), application)

    // Public variables
    var loginFieldError by mutableStateOf(LoginFieldError())

    // API Calls
    fun login(loginDetails: LoginDetails, onResponse: (Boolean, String) -> Unit) =
        viewModelScope.launch {
            when (val response = repository.login(loginDetails)) {
                is ResponseResource.Failure -> {
                    onResponse(false, response.errorMessage ?: "Login failed")
                }
                is ResponseResource.Success -> {
                    ifLet(
                        response.value.token,
                        response.value.name,
                        response.value.address,
                        response.value.type,
                        response.value._id
                    ) { (token, name, address, userType, userId) ->
                        saveStringToDataStore(
                            hashMapOf(
                                Constants.DataStore.Keys.authToken to token,
                                Constants.DataStore.Keys.userName to name,
                                Constants.DataStore.Keys.address to address,
                                Constants.DataStore.Keys.type to userType,
                                Constants.DataStore.Keys.userId to userId,
                            )
                        )
                    }
                    onResponse(true, "Successful Login")
                }
            }
        }

    // DataStore Methods
    private fun saveStringToDataStore(data: HashMap<String, String>) = viewModelScope.launch {
        repository.saveStringToDataStore(data)
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