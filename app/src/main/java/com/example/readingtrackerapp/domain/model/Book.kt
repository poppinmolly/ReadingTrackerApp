package com.example.readingtrackerapp.domain.model



data class Book(
    val id: String,
    val title: String?,
    val authors: String?,
    val pageCount: Int?,
    val averageRating: Double?,
    val description: String?,
    val thumbnail: String?
)