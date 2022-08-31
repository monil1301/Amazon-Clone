package com.shah.amazonclone.repositories

import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.models.auth.LoginDetails
import com.shah.amazonclone.network.LoginApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 31/08/22.
 */

class LoginRepository(
    private val api: LoginApi,
    private val application: AmazonCloneApplication
) : BaseRepository() {

    // API Calls
    suspend fun login(loginDetails: LoginDetails) =
        safeApiCall { api.login(loginDetails) }

    // DataStore Methods
    suspend fun saveStringToDataStore(data: HashMap<String, String>) =
        application.userPreferences?.saveStringData(data)
}
