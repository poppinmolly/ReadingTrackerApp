package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.repository.BookRepository
import javax.inject.Inject


class CheckUserProgressDailyUseCase @Inject constructor(
    private val repository: BookRepository
){
    suspend fun checkUserProgressDailyUseCase(){
        repository.checkDailyUserProgress()
    }
}