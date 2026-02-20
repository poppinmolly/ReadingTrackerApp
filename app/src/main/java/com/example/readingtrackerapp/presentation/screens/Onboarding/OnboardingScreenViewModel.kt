package com.example.readingtrackerapp.presentation.screens.Onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class OnboardingScreenViewModel @Inject constructor(): ViewModel(){
    var nameValue by mutableStateOf("")
        private set

    var pagesValue by mutableStateOf("")
        private set

    fun onNameChange(newName: String){
        nameValue = newName
    }

    fun onPagesChange(newPages: String){
        pagesValue = newPages
    }


}