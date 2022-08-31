package com.shah.amazonclone.utilities.helpers

import android.util.Log
import com.shah.amazonclone.BuildConfig

/**
 * Created by Monil Shah on 31/08/22.
 */

/**
 * It sends the log to sentry. Ii prints on logcat if running the debug build
 * @param tag tag for the log
 * @param message message to log
 * @param parameters parameters to be sent with the log
 */
fun logD(
    tag: String = "A_Log",
    message: String,
    parameters: Map<String, Any?>? = null,
) {
    if (BuildConfig.DEBUG) Log.d(tag, "message: $message, parameters: $parameters")
}
