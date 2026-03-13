package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.model.ReadingData
import com.example.readingtrackerapp.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodayReadPagesUseCase @Inject constructor(
    private val repository: BookRepository
){
    fun getReadingPages(): Flow<ReadingData> {
        return repository.getReadingPagesToday()
    }

}