package com.shah.amazonclone.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shah.amazonclone.models.Address
import com.shah.amazonclone.network.AddressApi
import com.shah.amazonclone.network.base.ApiBuilder
import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.repositories.AddressRepository
import com.shah.amazonclone.utilities.helpers.UserHelper
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 27/09/22.
 */

class AddressViewModel : ViewModel() {

    // Private variables
    private val apiBuilder = ApiBuilder()
    private val repository =
        AddressRepository(apiBuilder.buildApi(AddressApi::class.java))

    fun addAddress(address: Address, onComplete: () -> Unit) = viewModelScope.launch {
        when (val response = repository.addAddress(address)) {
            is ResponseResource.Failure -> {
                onComplete()
            }
            is ResponseResource.Success -> {
                UserHelper.user?.address = response.value.address
                onComplete()
            }
        }
    }
}
