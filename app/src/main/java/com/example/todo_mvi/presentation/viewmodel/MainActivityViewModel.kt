package com.example.todo_mvi.presentation.viewmodel

import android.text.TextUtils
import androidx.lifecycle.ViewModel
import com.example.todo_mvi.data.model.Tasks
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
            is HomeUIEvents.AddTask -> addNewTask(event.task)
            HomeUIEvents.CloseTaskDialog -> closeTaskDialog()
            is HomeUIEvents.CompletedTask -> addCompletedTasks(event.taskIndex)
            is HomeUIEvents.OpenTaskDialog -> openTaskDialog(event.task)
            HomeUIEvents.ToggleDialog -> toggleDialog()
        }
    }

    private fun toggleDialog() {
        _homeUIState.value = _homeUIState.value.copy(
            showDialog = !_homeUIState.value.showDialog
        )
    }

    private fun openTaskDialog(task: Tasks) {
        _homeUIState.value = _homeUIState.value.copy(
            openTaskDialog = !_homeUIState.value.openTaskDialog,
            selectedTask = task
        )
    }

    private fun addCompletedTasks(taskIndex: Int) {
        val taskList  = _homeUIState.value.taskList.toMutableList()
        val completedList  = _homeUIState.value.completedTaskList.toMutableList()
        if (taskIndex !in 0 until _homeUIState.value.taskList.size){
            return
        }

        val task = taskList[taskIndex]
        taskList.removeAt(taskIndex)
        completedList.add(task)

        _homeUIState.value = _homeUIState.value.copy(
            openTaskDialog = false,
            taskList = taskList,
            completedTaskList = completedList
        )
    }

    private fun closeTaskDialog() {
        _homeUIState.value = _homeUIState.value.copy(
            openTaskDialog = !_homeUIState.value.openTaskDialog
        )
    }

    private fun addNewTask(task: Tasks) {
        val list = _homeUIState.value.taskList

        if (TextUtils.isEmpty(task.taskName)){
            return
        }
        if (TextUtils.isEmpty(task.taskDetails)){
            return
        }
        if (TextUtils.isEmpty(task.taskEndDate)){
            return
        }

        list.add(task)

        _homeUIState.value = _homeUIState.value.copy(
            showDialog = !_homeUIState.value.showDialog,
            taskList = list
        )
    }


}
