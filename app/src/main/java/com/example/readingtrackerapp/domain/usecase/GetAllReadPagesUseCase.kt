package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.model.TotalStatsModel
import com.example.readingtrackerapp.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTimeStatsUseCase @Inject constructor(
    private val repository: BookRepository
){
    operator fun invoke(): Flow<TotalStatsModel> = repository.getAllTimeStats()
}