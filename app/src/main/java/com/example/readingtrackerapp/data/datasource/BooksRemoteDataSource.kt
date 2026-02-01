package com.example.readingtrackerapp.data.datasource

import android.util.Log
import com.example.readingtrackerapp.data.remote.api.ApiService
import com.example.readingtrackerapp.data.remote.dto.BookItemDto
import com.example.readingtrackerapp.data.remote.dto.BookResponseDto
import javax.inject.Inject
import com.example.readingtrackerapp.data.remote.apiconstants.BOOKS_API_KEY

class BooksRemoteDataSource @Inject constructor(private val api: ApiService) {
    suspend fun getBook(title: String): BookResponseDto{
        Log.d("ExploreVM", "API_KEY length = ${BOOKS_API_KEY.length}")
        return api.searchBooks(
            query = "intitle:$title",
            apiKey = BOOKS_API_KEY,
        )
    }

}