package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.repository.OnboardingRepository
import javax.inject.Inject

class ChangeOnboardingStatusUseCase @Inject constructor(
    private val repository: OnboardingRepository
){
    suspend operator fun invoke(){
        repository.setOnboardingComplete()
    }
}