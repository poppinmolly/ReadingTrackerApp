package com.example.readingtrackerapp.data.repository

import com.example.readingtrackerapp.data.datasource.BooksRemoteDataSource
import com.example.readingtrackerapp.data.mapper.toDomain
import com.example.readingtrackerapp.data.remote.api.ApiService
import com.example.readingtrackerapp.domain.model.Book
import com.example.readingtrackerapp.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    val dataSource: BooksRemoteDataSource
): BookRepository {
    override suspend fun getBook(title: String): List<Book> {
        val response = dataSource.getBook(title = title)
        return response.items?.map{it.toDomain()} ?: emptyList()
    }


}