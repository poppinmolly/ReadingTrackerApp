package com.example.readingtrackerapp.presentation.screens.Read

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readingtrackerapp.data.local.entity.FinishedBooks
import com.example.readingtrackerapp.domain.model.UserRankInfo
import com.example.readingtrackerapp.domain.usecase.GetCurrentRankProgressUseCase
import com.example.readingtrackerapp.domain.usecase.GetFinishedBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AllReadBooksScreenViewModel @Inject constructor(
    private val getFinishedBooksUseCase: GetFinishedBooksUseCase,
    private val getCurrentRankProgressUseCase: GetCurrentRankProgressUseCase
): ViewModel(){

    private val _finishedBooks = MutableStateFlow<List<FinishedBooks>>(emptyList())
    val finishedBooks: StateFlow<List<FinishedBooks>> = _finishedBooks.asStateFlow()

    init {
        viewModelScope.launch {
            _finishedBooks.value = getFinishedBooksUseCase.getFinishedBooksUseCase()
        }
    }

    val rankInfo: StateFlow<UserRankInfo?> = finishedBooks
        .map { getCurrentRankProgressUseCase(it.size) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = getCurrentRankProgressUseCase(0)
        )
}