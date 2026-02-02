package com.example.readingtrackerapp.domain.repository

import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.domain.model.Book

interface BookRepository{
    suspend fun getBook(title: String): List<Book>

    suspend fun addBook(book: Book)

    suspend fun getAllAddedBooks(): List<BookDetail>
}