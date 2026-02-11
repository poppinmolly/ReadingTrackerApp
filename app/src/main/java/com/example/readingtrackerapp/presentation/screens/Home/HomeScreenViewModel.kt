package com.example.readingtrackerapp.presentation.screens.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readingtrackerapp.data.local.entity.BookDetail
import com.example.readingtrackerapp.domain.usecase.ChangeReadTitlesUseCase
import com.example.readingtrackerapp.domain.usecase.ShowAllAddedBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllAddedBooksUseCase: ShowAllAddedBooksUseCase,
    private val changeReadTitlesUseCase: ChangeReadTitlesUseCase,
): ViewModel(){
    var _readingBooksAtNow = mutableStateOf<List<BookDetail>>(emptyList())
    val readingBooksAtNow: State<List<BookDetail>> = _readingBooksAtNow
    val booksReadingCounter: Int
        get() = _readingBooksAtNow.value.size

    private var _selectedBook = mutableStateOf<BookDetail?>(null)
    val selectedBook: State<BookDetail?> = _selectedBook

    private var _readTitlesValue = mutableStateOf<Int>(0)
    val readTitlesValue: State<Int> = _readTitlesValue

    fun selectedBook(book: BookDetail?){
        _selectedBook.value = book
    }

    fun clearSelectedBook(){
        _selectedBook.value = null
    }

    fun addValue(){
        _readTitlesValue.value += 1
    }

    fun subtractValue(){
        if (_readTitlesValue.value > 0){
            _readTitlesValue.value -= 1
        } else {
            return
        }

    }
    
    fun saveProgressReadingTitles(){
        viewModelScope.launch {
            changeReadTitlesUseCase(
                book = _selectedBook.value!!,
                titles = _readTitlesValue.value
            )
            _selectedBook.value = _selectedBook.value!!.copy(
                readTitle = _selectedBook.value!!.readTitle + _readTitlesValue.value
            )
            _readTitlesValue.value = 0
            getAllReadingBooks()
        }
    }



    fun getAllReadingBooks(){
        viewModelScope.launch {
            _readingBooksAtNow.value = getAllAddedBooksUseCase()
        }
    }

}