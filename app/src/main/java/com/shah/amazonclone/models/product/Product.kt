package com.shah.amazonclone.models.product

import android.os.Parcelable
import com.shah.amazonclone.utilities.helpers.UserHelper
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
    var quantity: Int? = null,
    var category: String? = null,
    var images: ArrayList<String>? = null,
    var ratings: List<Rating>? = null,
) : Parcelable {
    fun averageRating(): Float {
        var sum = 0F
        ratings?.forEach {
            sum += it.rating ?: 0F
        }

        ratings?.size?.takeIf { it > 0 }?.let {
            return if (sum > 0) sum / it else 0F
        } ?: kotlin.run {
            return 0F
        }
    }

    fun myRating(): Float =
        ratings?.firstOrNull { it.userId == UserHelper.user?.userId }?.rating ?: 0F
}
