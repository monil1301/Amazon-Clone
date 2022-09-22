package com.shah.amazonclone.network

import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.utilities.helpers.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Monil Shah on 17/09/22.
 */

interface ProductCategoryApi {

    @GET(Constants.API.Path.productByCategory)
    suspend fun getProductsByCategory(@Query(Constants.API.QueryParams.category) category: String): List<Product>?
}
