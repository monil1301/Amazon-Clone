package com.shah.amazonclone.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.models.Order
import com.shah.amazonclone.network.OrderApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.OrderRepository
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 27/09/22.
 */

class OrderViewModel : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        OrderRepository(apiBuilder.buildApi(OrderApi::class.java))

    fun placeOrder(order: Order, onComplete: (Boolean) -> Unit) = viewModelScope.launch {
        when (repository.placeOrder(order)) {
            is ResponseResource.Failure -> {
                onComplete(false)
            }
            is ResponseResource.Success -> {
                onComplete(true)
            }
        }
    }
}
