package com.shah.amazonclone.utilities.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 * Created by Monil Shah on 31/08/22.
 */

fun Activity.startActivityAndFinishCurrent(intent: Intent) {
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
}

fun Context.startActivityAndFinishCurrent(intent: Intent) {
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
}
