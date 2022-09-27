package com.shah.amazonclone.models.product

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Monil Shah on 27/09/22.
 */

@Parcelize
data class Rating(
    val userId: String? = null,
    val id: String? = null, // Product Id
    val rating: Float? = null
) : Parcelable
