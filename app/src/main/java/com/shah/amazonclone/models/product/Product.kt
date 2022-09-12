package com.shah.amazonclone.models.product

/**
 * Created by Monil Shah on 12/09/22.
 */

data class Product(
    val _id: String? = null,
    var name: String? = null,
    var description: String? = null,
    var price: Float? = null,
    var quality: Int? = null,
    var category: String? = null,
    var images: ArrayList<String>? = null
)
