package com.shah.amazonclone.network

import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.utilities.helpers.Constants
import retrofit2.http.GET

/**
 * Created by Monil Shah on 28/09/22.
 */

interface HomeApi {

    @GET(Constants.API.Path.getDealOfTheDay)
    suspend fun getDealOfTheDay(): Product
}
