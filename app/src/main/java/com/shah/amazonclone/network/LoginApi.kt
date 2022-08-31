package com.shah.amazonclone.network

import com.shah.amazonclone.models.auth.LoginDetails
import com.shah.amazonclone.models.auth.response.SignUpResponse
import com.shah.amazonclone.utilities.helpers.Constants
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Monil Shah on 31/08/22.
 */

interface LoginApi {

    @POST(Constants.API.Path.login)
    suspend fun login(@Body loginDetails: LoginDetails): SignUpResponse
}
