package com.shah.amazonclone.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.models.auth.SignUpDetails
import com.shah.amazonclone.models.auth.SignUpFieldError
import com.shah.amazonclone.network.SignUpApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.SignUpRepository
import com.shah.amazonclone.utilities.helpers.Constants
import com.shah.amazonclone.utilities.utils.ifLet
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 06/08/22.
 */

class SignUpViewModel(application: AmazonCloneApplication) : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        SignUpRepository(apiBuilder.buildApi(SignUpApi::class.java), application)

    // Public variables
    var signUpFieldError by mutableStateOf(SignUpFieldError())

    // API Calls
    fun signUp(signUpDetails: SignUpDetails, onResponse: (Boolean, String) -> Unit) =
        viewModelScope.launch {
            when (val response = repository.signUp(signUpDetails)) {
                is ResponseResource.Failure -> {
                    onResponse(false, response.errorMessage ?: "Sign up failed")
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
                    onResponse(true, "Successful Sign up")
                }
            }
        }

    // DataStore Methods
    private fun saveStringToDataStore(data: HashMap<String, String>) = viewModelScope.launch {
        repository.saveStringToDataStore(data)
    }

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