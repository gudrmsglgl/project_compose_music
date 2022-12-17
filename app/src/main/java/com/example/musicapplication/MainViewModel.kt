package com.example.musicapplication

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicapplication.MainState.Loading
import com.example.musicapplication.MainState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    val mainState: StateFlow<MainState> = flow<MainState> {
        delay(1000)
        emit(Success)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        Loading
    )


}

sealed class MainState {
    object Loading : MainState()
    object Success: MainState()
}