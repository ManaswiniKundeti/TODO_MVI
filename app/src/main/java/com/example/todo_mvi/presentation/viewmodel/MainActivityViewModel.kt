package com.example.todo_mvi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todo_mvi.presentation.event.HomeUIEvents
import com.example.todo_mvi.presentation.state.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(): ViewModel() {

    private val _homeUIState = MutableStateFlow(HomeUIState())
    val homeUIState = _homeUIState.asStateFlow()


    fun homeUIEvent(event: HomeUIEvents) {
        when(event) {
            is HomeUIEvents.AddTask -> TODO()
            HomeUIEvents.CloseTaskDialog -> TODO()
            is HomeUIEvents.CompletedTask -> TODO()
            is HomeUIEvents.OpenTaskDialog -> TODO()
            HomeUIEvents.ToggleDialog -> TODO()
        }
    }
}