package com.shah.amazonclone.network

import com.shah.amazonclone.models.Address
import com.shah.amazonclone.models.UserInfo
import com.shah.amazonclone.utilities.helpers.Constants
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Monil Shah on 09/10/22.
 */

interface AddressApi {

    @POST(Constants.API.Path.addAddress)
    suspend fun addAddress(@Body address: Address): UserInfo
}
