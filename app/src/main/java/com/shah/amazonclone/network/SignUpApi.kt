package com.shah.amazonclone.network

import com.shah.amazonclone.models.auth.SignUpDetails
import com.shah.amazonclone.models.auth.response.SignUpResponse
import com.shah.amazonclone.utilities.helpers.Constants
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Monil Shah on 31/08/22.
 */

interface SignUpApi {

    @POST(Constants.API.Path.signUp)
    suspend fun signUp(@Body signUpDetails: SignUpDetails): SignUpResponse
}