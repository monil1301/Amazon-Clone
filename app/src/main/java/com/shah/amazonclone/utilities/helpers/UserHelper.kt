package com.shah.amazonclone.utilities.helpers

import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.models.UserInfo
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
            )
        }
    }
}
