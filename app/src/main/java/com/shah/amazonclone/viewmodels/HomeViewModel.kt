package com.shah.amazonclone.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.network.HomeApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.HomeRepository
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 28/09/22.
 */

class HomeViewModel : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        HomeRepository(apiBuilder.buildApi(HomeApi::class.java))

    // Public variables
    var dealOfTheDay by mutableStateOf<Product?>(null)

    fun getDealOfTheDay() =
        viewModelScope.launch {
            when (val response = repository.getDealOfTheDay()) {
                is ResponseResource.Failure -> {}
                is ResponseResource.Success -> {
                    dealOfTheDay = response.value
                }
            }
        }
}
