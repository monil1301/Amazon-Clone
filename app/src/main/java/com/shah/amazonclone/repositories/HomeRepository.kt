package com.shah.amazonclone.repositories

import com.shah.amazonclone.network.HomeApi
import com.shah.amazonclone.repositories.base.BaseRepository

/**
 * Created by Monil Shah on 28/09/22.
 */

class HomeRepository(private val api: HomeApi) : BaseRepository() {

    suspend fun getDealOfTheDay() = safeApiCall {
        api.getDealOfTheDay()
    }
}
