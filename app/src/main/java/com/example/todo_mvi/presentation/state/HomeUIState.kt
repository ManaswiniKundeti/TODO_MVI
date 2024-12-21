package com.example.todo_mvi.presentation.state

import com.example.todo_mvi.data.model.Tasks

data class HomeUIState(
    val loading: Boolean = false,
    val showDialog: Boolean = false,
    val openTaskDialog: Boolean = false,
    val selectedTask: Tasks? = null,
    val taskList: MutableList<Tasks> = mutableListOf(),
    val completedTaskList: MutableList<Tasks> = mutableListOf(),
    val showError: Boolean = false,
    val errorMessage: String = ""
)
