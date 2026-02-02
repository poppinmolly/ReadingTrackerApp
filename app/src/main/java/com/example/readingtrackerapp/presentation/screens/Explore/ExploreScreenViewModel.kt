package com.example.readingtrackerapp.presentation.screens.Explore

import android.util.Log
import retrofit2.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readingtrackerapp.domain.model.Book
import com.example.readingtrackerapp.domain.usecase.GetBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import com.example.readingtrackerapp.domain.usecase.MarkReadableUseCase


import javax.inject.Inject


@HiltViewModel
class ExploreScreenViewModel @Inject constructor(
    private val getBookUseCase: GetBookUseCase,
    private val markReadableUseCase: MarkReadableUseCase,
): ViewModel(){
    private var _stateText by mutableStateOf("")
    val stateText: String get() = _stateText

    private var _booksAdded = mutableStateListOf<String>()
    val booksAdded: List<String> get() = _booksAdded

    fun onTextChange(text: String){
        _stateText  = text
    }

    var error by mutableStateOf<String?>(null)
        private set

    private val _books = mutableStateOf<List<Book>>(emptyList())
    val books: State<List<Book>> = _books

    fun searchBook() {
        val query = stateText
            .trim()

        if (query.isEmpty()) return
        viewModelScope.launch {
            error = null
            try {
                val result = getBookUseCase(query)
                _books.value = result
            } catch (e: HttpException) {
                if (e.code() == 429) {
                    error = "Too many requests. Please wait."
                }
            } catch (e: Exception) {
                error = "Something went wrong"
            } finally {
                _stateText = ""
            }
        }
    }

    fun addBookToReadList(book: Book){
        viewModelScope.launch {
            markReadableUseCase(book = book)
            if (!_booksAdded.contains(book.id)){
                _booksAdded.add(book.id)
            }
            Log.d("VASYAN", "Size of books ${booksAdded.size}")
        }
    }



}