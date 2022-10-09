package com.shah.amazonclone.models

import com.shah.amazonclone.enums.UserType

/**
 * Created by Monil Shah on 01/09/22.
 */

data class UserInfo(
    val name: String? = null,
    var address: String? = null,
    val type: UserType? = null,
    val userId: String? = null,
    var cart: List<CartItem>? = null
)
