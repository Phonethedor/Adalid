package com.adalid.individual3.Modelo.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Task::class], version = 1)
abstract class TaskDataBase: RoomDatabase() {

    abstract fun getTaskDao(): TaskDao


    companion object {
        @Volatile
        private var INSTANCE: TaskDataBase? = null


        fun getDatabase(context: Context): TaskDataBase {
            val tempInntance = INSTANCE
            if (tempInntance != null) {

                return tempInntance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDataBase::class.java,
                    "TaskEntity"
                )
                    .build()
                INSTANCE = instance
                return instance

            }
        }
    }
}