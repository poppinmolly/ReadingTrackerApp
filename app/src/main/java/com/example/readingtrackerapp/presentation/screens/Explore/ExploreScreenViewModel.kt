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
import kotlinx.coroutines.withTimeout


import javax.inject.Inject


@HiltViewModel
class ExploreScreenViewModel @Inject constructor(
    private val getBookUseCase: GetBookUseCase
): ViewModel(){
    private var _stateText by mutableStateOf("")
    val stateText: String get() = _stateText

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
                Log.d("ExploreVM", "state books now = ${_books.value.size}")

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

}