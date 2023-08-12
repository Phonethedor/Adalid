package com.adalid.plantapp.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adalid.plantapp.model.local.Entities.*

@Dao
interface PlantDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPlants(plantList: List<PlantEntity>)

    @Query("SELECT * FROM PLANT ORDER BY id ASC")
    fun getAllPlants(): LiveData<List<PlantEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlantDetail(phone: PlantDetailEntity)

    @Query("SELECT * FROM PLANT_DETAIL WHERE id=:id")
    fun getPlantDetailById(id: String): LiveData<PlantDetailEntity>
}