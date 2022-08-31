package com.shah.amazonclone.application

import android.app.Application
import com.shah.amazonclone.data.UserPreferences

/**
 * Created by Monil Shah on 31/08/22.
 */

class AmazonCloneApplication : Application() {

    val userPreferences: UserPreferences? by lazy { UserPreferences(this) }
}
