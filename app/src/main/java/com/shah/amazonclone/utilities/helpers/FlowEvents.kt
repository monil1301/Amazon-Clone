package com.shah.amazonclone.utilities.helpers

import com.shah.amazonclone.models.CartItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Created by Monil Shah on 08/10/22.
 */

object FlowEvents {

    private val userCartSharedFlow = MutableSharedFlow<List<CartItem>?>()
    val userCart = userCartSharedFlow.asSharedFlow()

    suspend fun emitUserCart(cart: List<CartItem>?) {
        userCartSharedFlow.emit(cart)
    }
}
