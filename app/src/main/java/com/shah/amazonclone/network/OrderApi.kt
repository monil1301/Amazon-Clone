package com.shah.amazonclone.network

import com.shah.amazonclone.models.Order
import com.shah.amazonclone.utilities.helpers.Constants
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Monil Shah on 09/10/22.
 */

interface OrderApi {

    @POST(Constants.API.Path.placeOrder)
    suspend fun placeOrder(@Body order: Order): Order
}
