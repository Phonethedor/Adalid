package com.adalid.plantapp.model.local.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adalid.plantapp.model.local.entities.*
import com.adalid.plantapp.model.local.PlantDAO

@Database(entities = [PlantEntity::class, PlantDetailEntity::class], version = 1, exportSchema = false)
abstract class PlantDB: RoomDatabase() {

    abstract fun getPlantDAO(): PlantDAO

    companion object {
        @Volatile
        private var
                INSTANCE: PlantDB? = null

        fun getDataBase(context: Context): PlantDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantDB::class.java, "plantApp_DB"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}