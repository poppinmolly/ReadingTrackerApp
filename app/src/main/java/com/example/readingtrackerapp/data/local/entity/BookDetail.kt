package com.example.readingtrackerapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_db")
data class BookDetail(
    @PrimaryKey (autoGenerate = true)
    val id: Long,
    val bookTitle: String,
    val bookAuthor: String,
    val readTitle: Int = 0,
    val apiId: String,
    val thumbnail: String,
    val totalTitles: Int,
    val timeReading: Int = 0,

)