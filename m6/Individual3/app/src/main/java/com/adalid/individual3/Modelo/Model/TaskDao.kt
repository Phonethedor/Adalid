package com.adalid.individual3.Modelo.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.adalid.individual3.Modelo.Model.Task


@Dao
interface TaskDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)


    @Insert
    suspend fun insertMultipleTask(List:List<Task>)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteOneTask(task: Task?)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM task_table")
     fun getAllTask1(): LiveData<List<Task>>

     //TODO ¿cuando una funcion es suspended o no en un dao?

     @Query("SELECT * FROM task_table ORDER BY id ASC")
     fun getAlltask(): LiveData<List<Task>>

     @Query("SELECT * FROM task_table WHERE title=:title LIMIT 1")
     fun getTaskByTitle(title: String): LiveData<Task>

     @Query("SELECT * FROM task_table WHERE id=:id LIMIT 1")
     fun getTaskById(id: Int): LiveData<Task>

}