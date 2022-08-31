package com.shah.amazonclone.repositories.base

import com.shah.amazonclone.network.base.ResponseResource
import com.shah.amazonclone.utilities.helpers.logD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> safeApiCall(api: suspend () -> T): ResponseResource<T> {
        return withContext(Dispatchers.IO) coroutine@{
            try {
                ResponseResource.Success(api.invoke())
            } catch (t: Throwable) {
                t.message?.let { message -> logD(message = "safeApiCall: $message") }
                when (t) {
                    is HttpException -> {
                        return@coroutine ResponseResource.Failure(false, t.message())
                    }
                    else -> {
                        return@coroutine ResponseResource.Failure(true, null)
                    }
                }
            }
        }
    }
}
