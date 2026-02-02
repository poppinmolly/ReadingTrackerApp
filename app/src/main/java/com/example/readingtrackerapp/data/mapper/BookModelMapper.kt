package com.example.readingtrackerapp.data.mapper

import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.domain.model.Book

fun Book.toEntity(): BookDetail =
    BookDetail(
        id = 0,
        bookTitle = title ?: "Unknown",
        bookAuthor = authors ?: "Unknown",
        totalTitles = pageCount?: 0,
        apiId = id,
        thumbnail = thumbnail?: "https://abrakadabra.fun/uploads/posts/2021-12/1639258998_3-abrakadabra-fun-p-znak-voprosa-na-chernom-fone-3.jpg"
    )