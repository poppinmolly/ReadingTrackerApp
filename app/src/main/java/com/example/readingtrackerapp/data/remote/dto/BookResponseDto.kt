package com.example.readingtrackerapp.data.remote.dto

data class BookResponseDto(
    val items: List<BookItemDto>?
)
data class BookItemDto(
    val id: String,
    val volumeInfo: VolumeInfoDto
)

data class VolumeInfoDto(
    val title: String?,
    val authors: List<String>?,
    val pageCount: Int?,
    val averageRating: Double?,
    val description: String?,
    val imageLinks: ImageLinksDto?
)

data class ImageLinksDto(
    val thumbnail: String?
)