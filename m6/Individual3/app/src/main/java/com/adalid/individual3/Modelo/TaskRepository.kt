package com.adalid.individual3.Modelo

import androidx.lifecycle.LiveData
import com.adalid.individual3.Modelo.Model.Task
import com.adalid.individual3.Modelo.Model.TaskDao

class TaskRepository (private val taskDao: TaskDao) {

    val listAllTask: LiveData<List<Task>> = taskDao.getAllTask1()


    suspend fun insertTask(task: Task){
        taskDao.insertTask(task)

    }

    suspend fun updateTask(task: Task){
        taskDao.updateTask(task)

    }

    suspend fun deleteAll(){
        taskDao.deleteAll()

    }

    suspend fun deleteOneTask(task: Task?){
        taskDao.deleteOneTask(task)

    }






}