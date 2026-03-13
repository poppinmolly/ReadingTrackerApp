package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.repository.BookRepository
import javax.inject.Inject

class AddNewReadingPagesUseCase @Inject constructor(
    private val repository: BookRepository
){
    suspend fun changeReadPages(pages: Int){
        repository.addTodayReadPages(pages = pages)
    }
}