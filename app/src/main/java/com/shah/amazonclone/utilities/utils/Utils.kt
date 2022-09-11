package com.shah.amazonclone.utilities.utils

/**
 * Created by Monil Shah on 31/08/22.
 */

inline fun <T : Any> ifLet(vararg elements: T?, closure: (List<T>) -> Unit) {
    if (elements.all { it != null }) {
        closure(elements.filterNotNull())
    }
}
