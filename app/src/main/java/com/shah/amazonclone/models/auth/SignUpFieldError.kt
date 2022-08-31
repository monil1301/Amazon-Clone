package com.shah.amazonclone.models.auth

/**
 * Created by Monil Shah on 30/08/22.
 */

class SignUpFieldError(
    var nameEmpty: Boolean = false,
    var nameMinLength: Boolean = false,
    emailEmpty: Boolean = false,
    emailInvalid: Boolean = false,
    passwordEmpty: Boolean = false,
    passwordLength: Boolean = false
) : LoginFieldError(
    emailEmpty, emailInvalid, passwordEmpty, passwordLength
)
