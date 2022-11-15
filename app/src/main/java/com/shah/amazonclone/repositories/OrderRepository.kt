package com.shah.amazonclone.repositories

import com.shah.amazonclone.models.Order
import com.shah.amazonclone.network.OrderApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 27/09/22.
 */

class OrderRepository(private val api: OrderApi) : BaseRepository() {

    suspend fun placeOrder(order: Order) = safeApiCall {
        api.placeOrder(order)
    }
}
