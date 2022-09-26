package com.shah.amazonclone.viewmodels

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.network.SearchApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.SearchRepository
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 23/09/22.
 */

class SearchViewModel : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        SearchRepository(apiBuilder.buildApi(SearchApi::class.java))

    // Public variables
    val products = SnapshotStateList<Product>()

    fun searchProduct(searchQuery: String, onResponse: (message: String?) -> Unit) =
        viewModelScope.launch {
            when (val response = repository.searchProduct(searchQuery)) {
                is ResponseResource.Failure -> {
                    onResponse(response.errorMessage)
                }
                is ResponseResource.Success -> {
                    products.clear()
                    products.addAll(response.value)
                }
            }
        }
}
