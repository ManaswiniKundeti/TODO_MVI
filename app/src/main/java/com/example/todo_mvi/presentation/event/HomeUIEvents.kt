package com.example.todo_mvi.presentation.event

import com.example.todo_mvi.data.model.Tasks

sealed interface HomeUIEvents {

    data object ToggleDialog: HomeUIEvents

    data class AddTask(val task: Tasks): HomeUIEvents

    data class CompletedTask(val taskIndex: Int): HomeUIEvents

    data class OpenTaskDialog(val task: Tasks): HomeUIEvents

    data object CloseTaskDialog: HomeUIEvents
}