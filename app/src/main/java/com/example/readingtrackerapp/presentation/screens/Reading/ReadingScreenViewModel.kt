package com.example.readingtrackerapp.presentation.screens.Reading

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.readingtrackerapp.domain.model.WeeklyStatsModel
import com.example.readingtrackerapp.domain.usecase.GetAllReadPagesUseCase
import com.example.readingtrackerapp.domain.usecase.GetStatForLastWeekUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ReadingScreenViewModel @Inject constructor(
    getAllReadPagesUseCase: GetAllReadPagesUseCase,
    getStatForLastWeekUseCase: GetStatForLastWeekUseCase
): ViewModel(){


    val totalReadPages: StateFlow<Int> = getAllReadPagesUseCase()
        .map{ it ?: 0}
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )
    private val _lastWeekStats = MutableStateFlow<WeeklyStatsModel?>(null)
    val lastWeekStats: StateFlow<WeeklyStatsModel?> = getStatForLastWeekUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null,
        )





}