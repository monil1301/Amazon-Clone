package com.shah.amazonclone.repositories

import com.shah.amazonclone.network.ProductCategoryApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 17/09/22.
 */

class ProductCategoryRepository(private val api: ProductCategoryApi) : BaseRepository() {

    suspend fun getProductsByCategory(category: String) = safeApiCall {
        api.getProductsByCategory(category)
    }
}
