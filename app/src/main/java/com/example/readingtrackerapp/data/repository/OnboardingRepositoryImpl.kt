package com.example.readingtrackerapp.data.repository

import com.example.readingtrackerapp.data.local.datastore.DataStoreManager
import com.example.readingtrackerapp.domain.repository.OnboardingRepository
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : OnboardingRepository{
    override suspend fun saveName(name: String) {
        dataStoreManager.setName(name = name)
    }

    override suspend fun savePagesTarget(pages: Int) {
        dataStoreManager.setPageTarget(pages = pages)
    }

    override suspend fun setOnboardingComplete() {
        dataStoreManager.setOnboardingComplete()
    }

}