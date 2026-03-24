package com.example.readingtrackerapp.data.local.datastore

import android.content.Context
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.readingtrackerapp.domain.model.ReadingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.temporal.ChronoUnit

private const val DATA_STORE_NAME = "user_preferences"

private val Context.dataStore by preferencesDataStore(
    name = DATA_STORE_NAME
)

class DataStoreManager (val context: Context){
    companion object{
        val ONBOARDING_COMPLETED = booleanPreferencesKey("ONBOARDING_COMPLETED")
        val NAME = stringPreferencesKey("NAME")
        val PAGES_TARGET = intPreferencesKey("PAGES_TARGET")

        val CURRENT_STREAK = intPreferencesKey("CURRENT_STREAK")
        val PAGES_READ_TODAY = intPreferencesKey("PAGES_READ_TODAY")
        val LAST_READ_PAGES = stringPreferencesKey("LAST_READ_PAGES")

        val BOOK_READ_TOTAL = intPreferencesKey("BOOK_READ_TOTAL")
        val BEST_STREAK_ALL_TIME = intPreferencesKey("BEST_STREAK_ALL_TIME")


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

    suspend fun incrementTotalReadBooks(){
        context.dataStore.edit {
            val current = it[BOOK_READ_TOTAL] ?: 0
            it[BOOK_READ_TOTAL] = current + 1
        }
    }
    // CREATE

    val readingData: Flow<ReadingData> = context.dataStore.data.map { prefs ->
        ReadingData(
            pagesReadToday = prefs[PAGES_READ_TODAY] ?: 0,
            currentReadingStreak = prefs[CURRENT_STREAK] ?: 0,
            lastReadPages = prefs[LAST_READ_PAGES]?.let{ LocalDate.parse(it)} ?: LocalDate.now(),
            booksReadTotal = prefs[BOOK_READ_TOTAL] ?: 0,
            bestStreakAllTime = prefs[BEST_STREAK_ALL_TIME] ?: 0,

        )
    }

    // EDIT
    suspend fun saveReadingProgress(pages: Int){
        val currentTime = LocalDate.now()
        context.dataStore.edit { preferences ->
            val lastDay = preferences[LAST_READ_PAGES]?.let { LocalDate.parse(it) } ?: currentTime
            val daysDiff = ChronoUnit.DAYS.between(lastDay, currentTime)
            val streak = preferences[CURRENT_STREAK] ?: 0

            preferences[PAGES_READ_TODAY] = if (daysDiff == 0L) (preferences[PAGES_READ_TODAY] ?: 0 ) + pages  else {
                0 + pages
            }

            preferences[CURRENT_STREAK] = when(daysDiff){
                0L -> streak
                1L -> streak + 1
                else -> {0}
            }

            preferences[LAST_READ_PAGES] = currentTime.toString()
        }
    }

    suspend fun checkUserProgress() {
        val currentTime = LocalDate.now()
        context.dataStore.edit { preferences ->
            val lastDay = preferences[LAST_READ_PAGES]?.let { LocalDate.parse(it) } ?: currentTime
            val daysDiff = ChronoUnit.DAYS.between(lastDay, currentTime)
            val bestStreak = preferences[BEST_STREAK_ALL_TIME] ?: 0
            val streak = preferences[CURRENT_STREAK] ?: 0
            preferences[BEST_STREAK_ALL_TIME] = (if (streak > bestStreak) streak else bestStreak)

            preferences[PAGES_READ_TODAY] =
                if (daysDiff == 0L) (preferences[PAGES_READ_TODAY] ?: 0) else {
                    0
                }
        }
    }






}