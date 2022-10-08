package com.shah.amazonclone.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.network.CartApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.CartRepository
import com.shah.amazonclone.utilities.helpers.FlowEvents
import com.shah.amazonclone.utilities.helpers.UserHelper
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 27/09/22.
 */

class CartViewModel : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        CartRepository(apiBuilder.buildApi(CartApi::class.java))

    fun addToCart(product: Product, onComplete: () -> Unit) = viewModelScope.launch {
        when (val response = repository.addToCart(product)) {
            is ResponseResource.Failure -> {
                onComplete()
            }
            is ResponseResource.Success -> {
                UserHelper.user?.cart = response.value.cart
                FlowEvents.emitUserCart(UserHelper.user?.cart)
                onComplete()
            }
        }
    }

    fun removeFromCart(id: String, onComplete: () -> Unit) = viewModelScope.launch {
        when (val response = repository.removeFromCart(id)) {
            is ResponseResource.Failure -> {
                onComplete()
            }
            is ResponseResource.Success -> {
                UserHelper.user?.cart = response.value.cart
                FlowEvents.emitUserCart(UserHelper.user?.cart)
                onComplete()
            }
        }
    }
}
