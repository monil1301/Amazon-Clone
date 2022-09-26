package com.shah.amazonclone.repositories

import com.shah.amazonclone.network.SearchApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 23/09/22.
 */

class SearchRepository(private val api: SearchApi) : BaseRepository() {

    suspend fun searchProduct(searchQuery: String) = safeApiCall {
        api.searchProduct(searchQuery)
    }
}
