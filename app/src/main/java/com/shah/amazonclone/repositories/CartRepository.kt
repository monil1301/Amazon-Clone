package com.shah.amazonclone.repositories

import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.network.CartApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 27/09/22.
 */

class CartRepository(private val api: CartApi) : BaseRepository() {

    suspend fun addToCart(product: Product) = safeApiCall {
        api.addToCart(product)
    }

    suspend fun removeFromCart(id: String) = safeApiCall {
        api.removeFromCart(id)
    }
}
