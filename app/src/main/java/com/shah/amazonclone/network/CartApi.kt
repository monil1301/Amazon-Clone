package com.shah.amazonclone.network

import com.shah.amazonclone.models.UserInfo
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.utilities.helpers.Constants
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Monil Shah on 09/10/22.
 */

interface CartApi {

    @POST(Constants.API.Path.addToCart)
    suspend fun addToCart(@Body product: Product): UserInfo

    @DELETE(Constants.API.Path.removeFromCart)
    suspend fun removeFromCart(@Path(Constants.API.QueryParams.id) id: String): UserInfo
}
