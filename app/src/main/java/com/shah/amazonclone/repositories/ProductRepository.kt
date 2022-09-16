package com.shah.amazonclone.repositories

import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.network.ProductApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 13/09/22.
 */

class ProductRepository(private val api: ProductApi) : BaseRepository() {

    suspend fun addProduct(product: Product) = safeApiCall {
        api.addProduct(product)
    }

    suspend fun getAllProducts() = safeApiCall {
        api.getAllProducts()
    }

    suspend fun deleteProduct(id: String) = safeApiCall {
        api.deleteProducts(Product(_id = id))
    }
}
