package com.shah.amazonclone.application

import android.app.Application
import com.cloudinary.android.MediaManager
import com.shah.amazonclone.data.UserPreferences

/**
 * Created by Monil Shah on 31/08/22.
 */

class AmazonCloneApplication : Application() {

    val userPreferences: UserPreferences? by lazy { UserPreferences(this) }

    override fun onCreate() {
        super.onCreate()
        MediaManager.init(this)
    }
}
