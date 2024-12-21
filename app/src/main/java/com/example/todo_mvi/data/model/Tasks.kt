package com.example.todo_mvi.data.model

data class Tasks(
    val taskId: Long,
    val taskName: String,
    val taskDetails: String,
    val taskEndDate: String,
    val taskFiles: MutableList<String> = mutableListOf()
)
