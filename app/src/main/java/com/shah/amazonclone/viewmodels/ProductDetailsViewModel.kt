package com.shah.amazonclone.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.models.product.Rating
import com.shah.amazonclone.network.ProductDetailsApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.repositories.ProductDetailsRepository
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 27/09/22.
 */

class ProductDetailsViewModel : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        ProductDetailsRepository(apiBuilder.buildApi(ProductDetailsApi::class.java))

    fun rateProduct(rating: Rating) = viewModelScope.launch {
        repository.rateProduct(rating)
    }
}
