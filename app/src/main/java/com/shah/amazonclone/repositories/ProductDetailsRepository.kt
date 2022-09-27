package com.shah.amazonclone.repositories

import com.shah.amazonclone.models.product.Rating
import com.shah.amazonclone.network.ProductDetailsApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 27/09/22.
 */

class ProductDetailsRepository(private val api: ProductDetailsApi) : BaseRepository() {

    suspend fun rateProduct(rating: Rating) = safeApiCall {
        api.rateProduct(rating)
    }
}
