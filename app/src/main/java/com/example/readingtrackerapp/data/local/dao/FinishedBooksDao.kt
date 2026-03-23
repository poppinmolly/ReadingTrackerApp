package com.example.readingtrackerapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.readingtrackerapp.data.local.entity.FinishedBooks

@Dao
interface FinishedBooksDao {

    @Query("SELECT * FROM FINISHED_BOOKS")
    suspend fun getFinishedBooks(): List<FinishedBooks>

    @Insert
    suspend fun addFinishedBook(finishedBook: FinishedBooks)
}