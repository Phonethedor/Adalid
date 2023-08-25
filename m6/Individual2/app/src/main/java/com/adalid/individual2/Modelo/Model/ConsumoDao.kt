package com.adalid.individual2.Modelo.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.adalid.individual2.Modelo.Model.Consumo


@Dao
interface ConsumoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarConsumo(consumo: Consumo)

    @Update
    suspend fun updateConsumo(consumo: Consumo)

    @Query("DELETE FROM TABLA_CONSUMO")
    suspend fun deleteAll()

    @Query("SELECT * FROM tabla_consumo")
    fun getAllConsumo():LiveData<List<Consumo>>

    @Delete
    suspend fun deleteUnConsumo(consumo: Consumo)



}