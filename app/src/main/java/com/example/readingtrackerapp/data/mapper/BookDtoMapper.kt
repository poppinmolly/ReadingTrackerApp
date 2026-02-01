package com.example.readingtrackerapp.data.mapper

import com.example.readingtrackerapp.data.remote.dto.BookItemDto
import com.example.readingtrackerapp.domain.model.Book

fun BookItemDto.toDomain(): Book =
    Book(
        id = id,
        title = volumeInfo.title,
        authors = volumeInfo.authors?.joinToString(", "),
        pageCount = volumeInfo.pageCount,
        averageRating = volumeInfo.averageRating,
        description = volumeInfo.description,
        thumbnail = volumeInfo.imageLinks?.thumbnail
            ?.replace("http://", "https://")
    )