package com.example.readingtrackerapp.domain.model

data class WeeklyStatsModel(
    val pagesRead: Int,
    val dailyAverage: Int,
    val readingTime: String
)