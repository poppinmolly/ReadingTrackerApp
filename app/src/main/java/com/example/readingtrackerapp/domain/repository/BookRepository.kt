package com.example.readingtrackerapp.domain.repository

import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.domain.model.Book
import com.example.readingtrackerapp.domain.model.TotalStatsModel
import com.example.readingtrackerapp.domain.model.WeeklyStatsModel
import kotlinx.coroutines.flow.Flow

interface BookRepository{
    suspend fun getBook(title: String): List<Book>

    suspend fun addBook(book: Book)

    suspend fun getAllAddedBooks(): List<BookDetail>

    suspend fun changeReadTitles(book: BookDetail, titles: Int)

    fun getAllTimeStats(): Flow<TotalStatsModel>

    fun getStatForLastWeek(lastSevenDays: Long): Flow<WeeklyStatsModel>
}