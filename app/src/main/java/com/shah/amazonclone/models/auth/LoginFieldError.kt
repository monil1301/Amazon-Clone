package com.shah.amazonclone.models.auth

/**
 * Created by Monil Shah on 31/08/22.
 */
open class LoginFieldError(
    var emailEmpty: Boolean = false,
    var emailInvalid: Boolean = false,
    var passwordEmpty: Boolean = false,
    var passwordLength: Boolean = false
)
