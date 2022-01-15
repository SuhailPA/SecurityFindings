package com.suhail.securityfindings.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map


class DataStoreFile(val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "dataStore")
    companion object {
        private val ONE_TIME = booleanPreferencesKey("oneTime")
    }


    suspend fun saveToDataStore(value: Boolean) {
        context.dataStore.edit {
            it[ONE_TIME] = value
        }
    }

    fun getDataStore() = context.dataStore.data.map {
        it[ONE_TIME] ?: false
    }
}