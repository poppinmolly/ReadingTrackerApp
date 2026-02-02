package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.domain.repository.BookRepository
import javax.inject.Inject

class ShowAllAddedBooksUseCase @Inject constructor(
    private val repository: BookRepository
){
    suspend operator fun invoke(): List<BookDetail>{
        return repository.getAllAddedBooks()
    }
}