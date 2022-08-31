package com.shah.amazonclone.ui.activities

import android.content.Intent
import androidx.activity.ComponentActivity
import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.utilities.helpers.Constants
import kotlinx.coroutines.runBlocking

class RoutesActivity : ComponentActivity() {

    override fun onStart() {
        super.onStart()

        navigateToActivity(getDestinationActivityIntent())
    }

    private fun navigateToActivity(destinationIntent: Intent) {
        startActivity(destinationIntent)
    }

    private fun getDestinationActivityIntent(): Intent {
        return runBlocking {
            return@runBlocking if ((application as AmazonCloneApplication).userPreferences?.getString(
                    Constants.DataStore.Keys.authToken
                ) == null
            ) {
                Intent(this@RoutesActivity, AuthActivity::class.java)
            } else {
                Intent(this@RoutesActivity, MainActivity::class.java)
            }
        }
    }
}
