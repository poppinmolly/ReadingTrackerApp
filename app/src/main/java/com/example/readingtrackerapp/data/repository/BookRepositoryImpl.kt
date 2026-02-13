package com.example.readingtrackerapp.data.repository

import com.example.readingtrackerapp.data.datasource.BooksRemoteDataSource
import com.example.readingtrackerapp.data.local.dao.BookDao
import com.example.readingtrackerapp.data.local.dao.StatsDao
import com.example.readingtrackerapp.data.local.database.BookDatabase
import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.data.local.entity.DailySession
import com.example.readingtrackerapp.data.mapper.toDomain
import com.example.readingtrackerapp.data.mapper.toEntity
import com.example.readingtrackerapp.domain.model.Book
import com.example.readingtrackerapp.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class BookRepositoryImpl @Inject constructor(
    val dataSource: BooksRemoteDataSource,
    var  bookDao: BookDao,
    var statsDao: StatsDao,
    val db: BookDatabase,
): BookRepository {
    override suspend fun getBook(title: String): List<Book> {
        val response = dataSource.getBook(title = title)
        return response.items?.map{it.toDomain()} ?: emptyList()
    }

    override suspend fun addBook(book: Book) {
        bookDao.insertBook(book.toEntity())
    }

    override suspend fun getAllAddedBooks(): List<BookDetail> {
        return bookDao.getAllBooks()

    }

    override suspend fun changeReadTitles(book: BookDetail, titles: Int ) {
        bookDao.addReadTitles(bookId = book.id, titles = titles )
        statsDao.insertDailyStats(
            DailySession(
                readPages = titles,
                bookId = book.id,
                id = 0,
            )
        )
    }

    override fun getAllReadTitles(): Flow<Int?> {
        return statsDao.getTotalPagesRead()
    }


}