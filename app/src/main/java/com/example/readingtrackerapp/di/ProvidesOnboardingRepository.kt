package com.example.readingtrackerapp.di

import com.example.readingtrackerapp.data.repository.OnboardingRepositoryImpl
import com.example.readingtrackerapp.domain.repository.OnboardingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class ProvidesOnboardingRepository{
    @Binds
    @Singleton
    abstract fun ProvidesOnboardingRepository(impl: OnboardingRepositoryImpl): OnboardingRepository
}

