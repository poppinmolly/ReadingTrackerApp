package com.example.readingtrackerapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.readingtrackerapp.data.local.dao.BookDao
import com.example.readingtrackerapp.data.local.entity.BookDetail

@Database(entities = [BookDetail::class], version = 3)
abstract class BookDatabase: RoomDatabase(){
    abstract fun bookDao(): BookDao
}