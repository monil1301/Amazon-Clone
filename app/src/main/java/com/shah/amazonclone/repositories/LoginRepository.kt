package com.shah.amazonclone.repositories

import com.shah.amazonclone.models.auth.LoginDetails
import com.shah.amazonclone.network.LoginApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 31/08/22.
 */

class LoginRepository(private val api: LoginApi) : BaseRepository() {

    suspend fun login(loginDetails: LoginDetails) =
        safeApiCall { api.login(loginDetails) }
}
