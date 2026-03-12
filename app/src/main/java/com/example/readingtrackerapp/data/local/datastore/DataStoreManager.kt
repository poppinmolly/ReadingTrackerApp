package com.example.readingtrackerapp.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.preferencesDataStoreFile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val DATA_STORE_NAME = "user_preferences"

private val Context.dataStore by preferencesDataStore(
    name = DATA_STORE_NAME
)

class DataStoreManager (val context: Context){
    companion object{
        val ONBOARDING_COMPLETED = booleanPreferencesKey("ONBOARDING_COMPLETED")
        val NAME = stringPreferencesKey("NAME")
        val PAGES_TARGET = intPreferencesKey("PAGES_TARGET")
    }

    // READ
    val isOnboardingComplete: Flow<Boolean> = context.dataStore.data.map { it[ONBOARDING_COMPLETED] ?: false }

    val name: Flow<String> = context.dataStore.data.map { it[NAME] ?: "" }

    val pagesTarget: Flow<Int> = context.dataStore.data.map { it[PAGES_TARGET] ?: 0 }

    // EDIT
    suspend fun setOnboardingComplete(){
        context.dataStore.edit { it[ONBOARDING_COMPLETED] = true }
    }

    suspend fun setName(name: String){
        context.dataStore.edit { it[NAME] = name }
    }

    suspend fun setPageTarget(pages: Int){
        context.dataStore.edit { it[PAGES_TARGET] = pages}
    }


}