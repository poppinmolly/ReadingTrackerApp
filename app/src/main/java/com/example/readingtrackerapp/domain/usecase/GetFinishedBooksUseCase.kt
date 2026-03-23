package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.data.local.entity.FinishedBooks
import com.example.readingtrackerapp.domain.repository.BookRepository
import javax.inject.Inject

class GetFinishedBooksUseCase @Inject constructor(
    private val repository: BookRepository
){
    suspend fun getFinishedBooksUseCase(): List<FinishedBooks>{
        return repository.getFinishedBooks()
    }
}