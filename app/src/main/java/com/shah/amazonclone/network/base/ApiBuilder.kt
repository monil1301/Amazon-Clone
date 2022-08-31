package com.shah.amazonclone.network.base

import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.utilities.helpers.Constants
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiBuilder {

    companion object {
        private const val baseUrl =
            "http://localHost:3000/" // replace localHost with your ip address
    }

    fun <Api> buildApi(api: Class<Api>, application: AmazonCloneApplication?): Api {

        val okHttpBuilder = OkHttpClient.Builder()
        val client = okHttpBuilder.addInterceptor { chain ->
            return@addInterceptor getResponse(chain, application)
        }.build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

    private fun getResponse(
        chain: Interceptor.Chain,
        application: AmazonCloneApplication?
    ): Response {
        val response = chain.proceed(chain.request().newBuilder().also { requestBuilder ->
            addHeaders(requestBuilder, application)
        }.build())

        return response
    }

    private fun addHeaders(
        requestBuilder: Request.Builder,
        application: AmazonCloneApplication?
    ) {
        requestBuilder.apply {
            header(
                Constants.API.Headers.accept,
                Constants.API.Headers.applicationJson
            )
            header(
                Constants.API.Headers.contentType,
                Constants.API.Headers.applicationJson
            )

            // Get access token from data store and send it in request header
            val accessToken =
                runBlocking { application?.userPreferences?.getString(Constants.DataStore.Keys.authToken) }

            header(
                Constants.API.Headers.authorization,
                Constants.API.Headers.getBearerToken(accessToken)
            )
        }
    }

}
