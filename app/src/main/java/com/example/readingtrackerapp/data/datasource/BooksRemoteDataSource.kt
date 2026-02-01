package com.example.readingtrackerapp.data.datasource

import com.example.readingtrackerapp.data.remote.api.ApiService
import com.example.readingtrackerapp.data.remote.dto.BookItemDto
import com.example.readingtrackerapp.data.remote.dto.BookResponseDto
import javax.inject.Inject

class BooksRemoteDataSource @Inject constructor(private val api: ApiService) {
    suspend fun getBook(title: String): BookResponseDto{
        return api.searchBooks(query = "intitle:$title")
    }

}