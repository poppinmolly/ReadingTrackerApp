package com.example.readingtrackerapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_db")
data class BookDetail(
    @PrimaryKey (autoGenerate = true)
    val id: Long,
    val bookTitle: String,
    val readTitle: Int,
    val totalTitles: Int,

)