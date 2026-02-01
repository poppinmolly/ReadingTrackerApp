package com.example.readingtrackerapp.data.remote.api

import android.telecom.Call
import androidx.room.Query
import com.example.readingtrackerapp.data.remote.dto.BookResponseDto
import retrofit2.http.GET

interface ApiService {
    @GET("volumes")
    suspend fun searchBooks(
        @retrofit2.http.Query("q") query: String,
        @retrofit2.http.Query("key") apiKey: String,
    ): BookResponseDto
}