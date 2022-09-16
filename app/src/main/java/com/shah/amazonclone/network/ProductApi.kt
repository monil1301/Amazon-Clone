package com.shah.amazonclone.network

import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.utilities.helpers.Constants
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Monil Shah on 13/09/22.
 */

interface ProductApi {

    @POST(Constants.API.Path.addProduct)
    suspend fun addProduct(@Body product: Product): Product

    @GET(Constants.API.Path.allProducts)
    suspend fun getAllProducts(): List<Product>?

    @POST(Constants.API.Path.deleteProduct)
    suspend fun deleteProducts(@Body deleteProduct: Product): Product?
}
