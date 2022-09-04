package com.shah.amazonclone.enums

import com.google.gson.annotations.SerializedName

/**
 * Created by Monil Shah on 05/09/22.
 */

enum class UserType() {
    @SerializedName("user")
    USER,
    @SerializedName("admin")
    ADMIN;

    companion object {
        fun getType(value: String): UserType? {
            return try {
                valueOf(value.uppercase())
            } catch (e: IllegalArgumentException) {
                null
            }
        }
    }
}
