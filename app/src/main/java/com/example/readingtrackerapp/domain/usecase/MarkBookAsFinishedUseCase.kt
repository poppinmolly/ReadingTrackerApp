package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.domain.repository.BookRepository
import javax.inject.Inject

class MarkBookAsFinishedUseCase @Inject constructor(
    private val repository: BookRepository,
){
    suspend fun markBookAsFinishedUseCase(book: BookDetail){
        repository.markBookAsFinished(book = book)
    }
}