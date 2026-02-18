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
import com.example.readingtrackerapp.domain.model.TotalStatsModel
import com.example.readingtrackerapp.domain.model.WeeklyStatsModel
import com.example.readingtrackerapp.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
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
    override fun getAllTimeStats(): Flow<TotalStatsModel> = flow {
        val totalStat = statsDao.getAllTimeStats()

        emit(
            TotalStatsModel(
                totalReadingBooks = totalStat.sumOf { it.booksRead },
                totalPagesRead = totalStat.sumOf { it.readPages },
                totalBestStreak = totalStat.sumOf { it.id.toInt() }
            )
        )
    }

    fun calculateReadingTime(total: Int): String {
        val totalMinutes = total * 2
        val h = totalMinutes / 60
        val m = totalMinutes % 60
        return "$h h $m minutes"
    }

    override fun getStatForLastWeek(lastSevenDays: Long): Flow<WeeklyStatsModel> = flow {
        val weeklyDays = statsDao.getLastWeekStats(lastSevenDays)
        val days = System.currentTimeMillis() - weeklyDays[0].date
        val streakDays = if (days.toInt() / 86400000 == 0) 1 else days / 86400000
        val total = weeklyDays.sumOf { it.readPages }

        val average = if (weeklyDays.isNotEmpty() && streakDays.toInt() == 7) total / 7 else total / streakDays.toInt()

        val readingTime = calculateReadingTime(total)
        emit(WeeklyStatsModel(
            pagesRead = total,
            dailyAverage = average,
            readingTime = readingTime
        ))
    }


}