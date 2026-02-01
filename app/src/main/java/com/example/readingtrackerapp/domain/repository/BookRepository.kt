package com.example.readingtrackerapp.domain.repository

import com.example.readingtrackerapp.domain.model.Book

interface BookRepository{
    suspend fun getBook(title: String): List<Book>
}