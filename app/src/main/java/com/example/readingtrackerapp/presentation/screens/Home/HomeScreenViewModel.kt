package com.example.readingtrackerapp.presentation.screens.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.domain.usecase.ShowAllAddedBooksUseCase
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

    private var _selectedBook = mutableStateOf<BookDetail?>(null)
    val selectedBook: State<BookDetail?> = _selectedBook

    fun selectedBook(book: BookDetail?){
        _selectedBook.value = book
    }

    fun clearSelectedBook(){
        _selectedBook.value = null
    }


    fun getAllReadingBooks(){
        viewModelScope.launch {
            _readingBooksAtNow.value = getAllAddedBooksUseCase()
        }
    }

}