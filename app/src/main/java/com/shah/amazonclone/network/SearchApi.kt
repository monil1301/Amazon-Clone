package com.shah.amazonclone.network

import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.utilities.helpers.Constants
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Monil Shah on 23/09/22.
 */

interface SearchApi {

    @GET(Constants.API.Path.searchProduct)
    suspend fun searchProduct(@Path(Constants.API.QueryParams.name) searchQuery: String): List<Product>
}
