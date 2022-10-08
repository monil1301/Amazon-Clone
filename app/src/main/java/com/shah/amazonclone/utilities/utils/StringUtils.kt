package com.shah.amazonclone.utilities.utils

import android.content.Context
import androidx.annotation.PluralsRes

/**
 * Created by Monil Shah on 09/10/22.
 */

fun Context.getIntQuantityString(@PluralsRes pluralStringResource: Int, quantity: Int): String {
    return resources.getQuantityString(
        pluralStringResource,
        quantity,
        quantity
    )
}
