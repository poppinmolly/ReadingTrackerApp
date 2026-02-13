package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllReadPagesUseCase @Inject constructor(
    private val repository: BookRepository
){
    operator fun invoke(): Flow<Int?> = repository.getAllReadTitles()
}