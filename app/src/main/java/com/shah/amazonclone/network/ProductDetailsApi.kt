package com.shah.amazonclone.network

import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.models.product.Rating
import com.shah.amazonclone.utilities.helpers.Constants
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Monil Shah on 27/09/22.
 */

interface ProductDetailsApi {

    @POST(Constants.API.Path.rateProduct)
    suspend fun rateProduct(@Body rating: Rating): Product
}
