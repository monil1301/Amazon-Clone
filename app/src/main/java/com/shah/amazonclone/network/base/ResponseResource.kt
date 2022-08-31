package com.shah.amazonclone.network.base

/**
 * Created by Monil Shah on 31/08/22.
 */

sealed class ResponseResource<out T> {

    data class Success<out T>(val value: T) : ResponseResource<T>()

    data class Failure(
        val isNetworkError: Boolean?,
        val errorMessage: String?,
    ) : ResponseResource<Nothing>()
}
