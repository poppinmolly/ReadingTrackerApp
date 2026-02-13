package com.example.readingtrackerapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sessions_db")
data class DailySession(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val readPages: Int,
    val bookId: Long,
    val date: Long = System.currentTimeMillis()
)
