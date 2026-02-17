package com.example.readingtrackerapp.domain.usecase

import com.example.readingtrackerapp.domain.model.WeeklyStatsModel
import com.example.readingtrackerapp.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStatForLastWeekUseCase @Inject constructor(
    private val repository: BookRepository
){


    operator fun invoke(): Flow<WeeklyStatsModel> {
        val lastSevenDays = System.currentTimeMillis() - 604800000
        return repository.getStatForLastWeek(lastSevenDays = lastSevenDays)
    }

}