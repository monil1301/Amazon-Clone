package com.shah.amazonclone.viewmodels

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.network.ProductApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.ProductRepository
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 13/09/22.
 */

class ProductViewModel() : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        ProductRepository(apiBuilder.buildApi(ProductApi::class.java))

    // Public variables
    val products = SnapshotStateList<Product>()

    fun addProduct(product: Product, onResponse: (isSuccess: Boolean, message: String?) -> Unit) =
        viewModelScope.launch {
            when (val response = repository.addProduct(product)) {
                is ResponseResource.Failure -> {
                    onResponse(false, response.errorMessage)
                }
                is ResponseResource.Success -> {
                    onResponse(true, "Added Successfully")
                }
            }
        }

    fun getAllProducts(onResponse: (message: String?) -> Unit) = viewModelScope.launch {
        when (val response = repository.getAllProducts()) {
            is ResponseResource.Failure -> {
                onResponse(response.errorMessage)
            }
            is ResponseResource.Success -> {
                response.value?.let { products.addAll(it) }
            }
        }
    }

    fun deleteProduct(id: String, onResponse: (message: String?) -> Unit) = viewModelScope.launch {
        when (val response = repository.deleteProduct(id)) {
            is ResponseResource.Failure -> {
                onResponse(response.errorMessage)
            }
            is ResponseResource.Success -> {
                products.removeIf { it._id == response.value?._id }
            }
        }
    }
}
