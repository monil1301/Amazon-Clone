package com.shah.amazonclone.repositories

import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.models.auth.SignUpDetails
import com.shah.amazonclone.network.SignUpApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 31/08/22.
 */
class SignUpRepository(
    private val api: SignUpApi,
    private val application: AmazonCloneApplication
) : BaseRepository() {

    // API Calls
    suspend fun signUp(signUpDetails: SignUpDetails) =
        safeApiCall { api.signUp(signUpDetails) }

    // DataStore Methods
    suspend fun saveStringToDataStore(data: HashMap<String, String>) =
        application.userPreferences?.saveStringData(data)
}
