package com.example.readingtrackerapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "finished_books")
data class FinishedBooks(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titleOfBook: String,
    val authorOfBook: String,
    val dateOfFinished: Long,
    val pagesRead: Int,
    val thumbnail: String = ""
)