package com.example.readingtrackerapp.presentation.screens.Reading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readingtrackerapp.domain.model.TotalStatsModel
import com.example.readingtrackerapp.domain.model.WeeklyStatsModel
import com.example.readingtrackerapp.domain.usecase.GetAllTimeStatsUseCase
import com.example.readingtrackerapp.domain.usecase.GetStatForLastWeekUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ReadingScreenViewModel @Inject constructor(
    getAllTimeStatsUseCase: GetAllTimeStatsUseCase,
    getStatForLastWeekUseCase: GetStatForLastWeekUseCase
): ViewModel(){


    val totalReadStats: StateFlow<TotalStatsModel> = getAllTimeStatsUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = TotalStatsModel()
        )

    val lastWeekStats: StateFlow<WeeklyStatsModel?> = getStatForLastWeekUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null,
        )







}