package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.repository.OnboardingRepository
import javax.inject.Inject

class SetPagesTargetUseCase @Inject constructor(
    private val repository: OnboardingRepository
){
    suspend operator fun invoke(pages: Int){
        repository.savePagesTarget(pages = pages)
        
    }
}