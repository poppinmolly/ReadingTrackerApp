package com.example.readingtrackerapp.domain.model

import java.time.LocalDate

data class ReadingData(
    val pagesReadToday: Int,
    val lastReadPages: LocalDate,
    val currentReadingStreak: Int = 0,
    val bestStreakAllTime: Int = 0,
    val booksReadTotal: Int = 0,
)
