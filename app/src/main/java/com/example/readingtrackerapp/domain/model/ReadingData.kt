package com.example.readingtrackerapp.domain.model

import java.time.LocalDate

data class ReadingData(
    val pagesReadToday: Int,
    val lastReadPages: LocalDate,
)
