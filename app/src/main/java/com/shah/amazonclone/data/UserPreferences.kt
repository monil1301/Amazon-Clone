package com.shah.amazonclone.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.shah.amazonclone.utilities.helpers.Constants
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * Created by Monil Shah on 31/08/22.
 */

class UserPreferences(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.DataStore.name)

    // Helper methods to save data
    suspend fun saveStringData(data: HashMap<String, String>) {
        context.dataStore.edit { preferences ->
            for ((key, value) in data.asIterable()) {
                preferences[stringPreferencesKey(key)] = value
            }
        }
    }

    // Helper methods to get data
    suspend fun getString(key: String): String? {
        val dataStoreKey = stringPreferencesKey(key)
        val preferences = context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emptyPreferences()
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[dataStoreKey]
            }

        return try {
            preferences.first()
        } catch (e: NoSuchElementException) {
            null
        }
    }
}
