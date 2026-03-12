package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.repository.OnboardingRepository
import javax.inject.Inject

class SetUserNameUseCase @Inject constructor(
    private val repository: OnboardingRepository
){
    suspend operator fun invoke(name: String){
        repository.saveName(name = name)
    }
}