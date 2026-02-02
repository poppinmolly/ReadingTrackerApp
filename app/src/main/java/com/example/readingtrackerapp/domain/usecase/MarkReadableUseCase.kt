package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.model.Book
import com.example.readingtrackerapp.domain.repository.BookRepository
import javax.inject.Inject

class MarkReadableUseCase @Inject constructor(
    private val repository: BookRepository
){
    suspend operator fun invoke(book: Book){
        repository.addBook(book)
    }
}