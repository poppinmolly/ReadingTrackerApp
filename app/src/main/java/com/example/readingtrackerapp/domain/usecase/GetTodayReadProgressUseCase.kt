package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.model.ReadingData
import com.example.readingtrackerapp.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodayReadProgressUseCase @Inject constructor(
    private val repository: BookRepository
){
    fun getReadingData(): Flow<ReadingData> {
        return repository.getReadingProgressToday()
    }
}