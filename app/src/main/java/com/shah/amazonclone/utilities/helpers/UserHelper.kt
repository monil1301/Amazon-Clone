package com.shah.amazonclone.utilities.helpers

import android.content.Intent
import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.enums.UserType
import com.shah.amazonclone.models.UserInfo
import com.shah.amazonclone.ui.activities.AuthActivity
import com.shah.amazonclone.utilities.utils.startActivityAndFinishCurrent
import kotlinx.coroutines.runBlocking

/**
 * Created by Monil Shah on 01/09/22.
 */

object UserHelper {

    var user: UserInfo? = null
    var accessToken: String? = null
        private set

    fun getUserDetails(application: AmazonCloneApplication) {
        user = runBlocking {
            val type =
                application.userPreferences?.getString(Constants.DataStore.Keys.type).toString()
            accessToken = application.userPreferences?.getString(Constants.DataStore.Keys.authToken)
                .toString()
            UserInfo(
                name = application.userPreferences?.getString(Constants.DataStore.Keys.userName),
                address = application.userPreferences?.getString(Constants.DataStore.Keys.address),
                userId = application.userPreferences?.getString(Constants.DataStore.Keys.userId),
                type = UserType.getType(type)
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
