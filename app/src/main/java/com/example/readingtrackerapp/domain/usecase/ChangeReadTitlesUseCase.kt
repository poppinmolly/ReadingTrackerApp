package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.domain.repository.BookRepository
import javax.inject.Inject

class ChangeReadTitlesUseCase @Inject constructor(
    private val repository: BookRepository
){
    suspend operator fun invoke(book: BookDetail, titles: Int){
        repository.changeReadTitles(
            book = book,
            titles = titles
        )
    }
}