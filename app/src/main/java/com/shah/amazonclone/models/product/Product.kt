package com.shah.amazonclone.models.product

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Monil Shah on 12/09/22.
 */

@Parcelize
data class Product(
    val _id: String? = null,
    var name: String? = null,
    var description: String? = null,
    var price: Float? = null,
    var rating: Float? = null,
    var quantity: Int? = null,
    var category: String? = null,
    var images: ArrayList<String>? = null
) : Parcelable
