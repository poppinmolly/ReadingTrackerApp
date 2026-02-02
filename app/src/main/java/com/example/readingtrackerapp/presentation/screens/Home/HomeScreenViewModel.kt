package com.example.readingtrackerapp.presentation.screens.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.domain.usecase.ShowAllAddedBooksUseCase
import com.example.readingtrackerapp.presentation.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllAddedBooksUseCase: ShowAllAddedBooksUseCase
): ViewModel(){

    var _readingBooksAtNow = mutableStateOf<List<BookDetail>>(emptyList())
    val readingBooksAtNow: State<List<BookDetail>> = _readingBooksAtNow
    val booksReadingCounter: Int
        get() = _readingBooksAtNow.value.size


    fun getAllReadingBooks(){
        viewModelScope.launch {
            _readingBooksAtNow.value = getAllAddedBooksUseCase()
        }
    }

}