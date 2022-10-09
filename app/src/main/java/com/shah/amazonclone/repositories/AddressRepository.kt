package com.shah.amazonclone.repositories

import com.shah.amazonclone.models.Address
import com.shah.amazonclone.network.AddressApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 27/09/22.
 */

class AddressRepository(private val api: AddressApi) : BaseRepository() {

    suspend fun addAddress(address: Address) = safeApiCall {
        api.addAddress(address)
    }
}
