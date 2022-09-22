package com.shah.amazonclone.viewmodels

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.network.ProductCategoryApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.ProductCategoryRepository
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 17/09/22.
 */

class ProductCategoryViewModel : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        ProductCategoryRepository(apiBuilder.buildApi(ProductCategoryApi::class.java))

    // Public variables
    val products = SnapshotStateList<Product>()

    fun getProductsByCategory(category: String) = viewModelScope.launch {
        when (val response = repository.getProductsByCategory(category)) {
            is ResponseResource.Failure -> {}
            is ResponseResource.Success -> {
                response.value?.let { products.addAll(it) }
            }
        }
    }
}
