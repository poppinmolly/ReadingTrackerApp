package com.example.readingtrackerapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.readingtrackerapp.data.local.dao.BookDao
import com.example.readingtrackerapp.data.local.dao.FinishedBooksDao
import com.example.readingtrackerapp.data.local.dao.StatsDao
import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.data.local.entity.DailySession
import com.example.readingtrackerapp.data.local.entity.FinishedBooks

@Database(entities = [BookDetail::class, DailySession::class, FinishedBooks::class], version = 9)
abstract class BookDatabase: RoomDatabase(){
    abstract fun bookDao(): BookDao
    abstract fun statsDao(): StatsDao
    abstract fun finishedBooksDao(): FinishedBooksDao
}