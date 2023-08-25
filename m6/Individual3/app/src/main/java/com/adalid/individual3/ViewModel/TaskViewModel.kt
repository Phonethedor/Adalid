package com.adalid.individual3.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adalid.individual3.Modelo.Model.Task
import com.adalid.individual3.Modelo.Model.TaskDao
import com.adalid.individual3.Modelo.Model.TaskDataBase
import com.adalid.individual3.Modelo.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel (application: Application): AndroidViewModel(application) {

    private val repository: TaskRepository

    val allTask: LiveData<List<Task>>


    init {

        val TaskDao= TaskDataBase.getDatabase(application).getTaskDao()

        repository= TaskRepository(TaskDao)

        allTask=repository.listAllTask
    }

    fun insertTask(task: Task)= viewModelScope.launch {
        repository.insertTask(task)

    }

    fun updateTask(task: Task)= viewModelScope.launch {
        repository.updateTask(task)
    }

    fun deleteAllTask()=viewModelScope.launch {
        repository.deleteAll()
    }

    fun deleteOneTask(task: Task?)=viewModelScope.launch {
       repository.deleteOneTask(task)
    }

    private val selectedTask: MutableLiveData<Task?> = MutableLiveData()


    fun selectedItem(): LiveData<Task?> =selectedTask

    fun selected(task: Task?){
        selectedTask.value=task
    }

}