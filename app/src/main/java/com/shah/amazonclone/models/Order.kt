package com.shah.amazonclone.models

/**
 * Created by Monil Shah on 10/10/22.
 */

data class Order(
    val products: List<CartItem>?,
    val totalPrice: Float?,
    val address: String?,
    val orderedAt: Long? = null,
    val paymentStatus: Int?,
    val status: Int? = null
)
