package com.shah.amazonclone.repositories

import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.network.AddProductApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 13/09/22.
 */

class AddProductRepository(private val api: AddProductApi) : BaseRepository() {

    suspend fun addProduct(product: Product) = safeApiCall {
        api.addProduct(product)
    }
}
