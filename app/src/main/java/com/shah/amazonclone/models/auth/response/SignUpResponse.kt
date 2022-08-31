package com.shah.amazonclone.models.auth.response

/**
 * Created by Monil Shah on 31/08/22.
 */
data class SignUpResponse(
    val _id: String?,
    val address: String?,
    val email: String?,
    val name: String?,
    val token: String?,
    val type: String?
)
