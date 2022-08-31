package com.shah.amazonclone.models.auth

/**
 * Created by Monil Shah on 30/08/22.
 */

class SignUpDetails(
    var name: String? = null,
    email: String? = null,
    password: String? = null,
) : LoginDetails(
    email, password
)
