package com.example.readingtrackerapp.domain.repository

interface OnboardingRepository {

    suspend fun saveName(name: String)
    suspend fun savePagesTarget(pages: Int)
    suspend fun setOnboardingComplete()
}