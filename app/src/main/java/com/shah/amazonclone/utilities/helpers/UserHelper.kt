package com.shah.amazonclone.utilities.helpers

import android.content.Intent
import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.models.UserInfo
import com.shah.amazonclone.ui.activities.AuthActivity
import kotlinx.coroutines.runBlocking

/**
 * Created by Monil Shah on 01/09/22.
 */

object UserHelper {

    var user: UserInfo? = null

    fun getUserDetails(application: AmazonCloneApplication) {
        user = runBlocking {
            UserInfo(
                name = application.userPreferences?.getString(Constants.DataStore.Keys.userName),
                address = application.userPreferences?.getString(Constants.DataStore.Keys.address),
            )
        }
    }

    fun logout(application: AmazonCloneApplication) {
        runBlocking { application.userPreferences?.clearDataStore() }
        application.applicationContext.startActivityAndFinishCurrent(
            Intent(
                application.applicationContext,
                AuthActivity::class.java
            )
        )
    }
}
