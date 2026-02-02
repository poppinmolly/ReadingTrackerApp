package com.example.readingtrackerapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.readingtrackerapp.data.local.entity.BookDetail

@Dao
interface BookDao{
    @Query("SELECT * FROM books_db")
    suspend fun getAllBooks(): List<BookDetail>

    @Insert
    suspend fun insertBook(book: BookDetail)

    @Delete
    suspend fun deleteBook(book: BookDetail)


}