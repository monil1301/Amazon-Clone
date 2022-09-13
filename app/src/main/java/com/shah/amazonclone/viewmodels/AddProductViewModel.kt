package com.shah.amazonclone.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.network.AddProductApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.AddProductRepository
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 13/09/22.
 */

class AddProductViewModel(application: AmazonCloneApplication) : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        AddProductRepository(apiBuilder.buildApi(AddProductApi::class.java, application))

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
}
