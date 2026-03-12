package com.example.readingtrackerapp.presentation.screens.Onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readingtrackerapp.data.local.datastore.DataStoreManager
import com.example.readingtrackerapp.domain.usecase.ChangeOnboardingStatusUseCase
import com.example.readingtrackerapp.domain.usecase.SetPagesTargetUseCase
import com.example.readingtrackerapp.domain.usecase.SetUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingScreenViewModel @Inject constructor(
    private val setUserNameUseCase: SetUserNameUseCase,
    private val setPagesTargetUseCase: SetPagesTargetUseCase,
    private val onboardingStatusUseCase: ChangeOnboardingStatusUseCase,
    private val dataStoreManager: DataStoreManager
): ViewModel(){
    var nameValue by mutableStateOf("")
        private set
    var pagesValue by mutableStateOf("")
        private set
    var pagesSelected by mutableStateOf("")
    fun onNameChange(newName: String){
        nameValue = newName
    }

    val isOnboardingComplete = dataStoreManager.isOnboardingComplete.stateIn(viewModelScope,
        SharingStarted.WhileSubscribed(), false)


    fun onPagesChange(newPages: String){
        pagesValue = newPages
        pagesSelected = newPages
    }

    fun onboardingComplete(){
        viewModelScope.launch {
            onboardingStatusUseCase()
            setPagesTargetUseCase(pages = pagesValue.toInt())
            setUserNameUseCase(name = nameValue)
        }
    }





}