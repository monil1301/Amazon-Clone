package com.shah.amazonclone.models.auth

/**
 * Created by Monil Shah on 30/08/22.
 */

data class SignUpFieldError(
    var nameEmpty: Boolean = false,
    var nameMinLength: Boolean = false,
    var emailEmpty: Boolean = false,
    var emailInvalid: Boolean = false,
    var passwordEmpty: Boolean = false,
    var passwordLength: Boolean = false
)
