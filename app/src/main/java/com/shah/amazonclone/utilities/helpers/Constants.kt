package com.shah.amazonclone.utilities.helpers

/**
 * Created by Monil Shah on 30/08/22.
 */

object Constants {

    object Size {
        const val userNameMinimumLength = 3
        const val passwordMinimumLength = 4
    }

    object Validation {
        const val emailPattern = "[a-zA-Z0-9.-_]+@[a-zA-Z0-9]+\\.+[a-z]+"
    }

    object API {
        object Headers {
            const val accept = "Accept"
            const val applicationJson = "application/json"
            const val contentType = "Content-Type"
            const val authorization = "Authorization"
            private const val bearer = "Bearer"

            fun getBearerToken(token: String?): String = "$bearer $token"
        }

        object Path {
            const val signUp = "api/signUp"
            const val login = "api/signIn"
        }
    }
}
