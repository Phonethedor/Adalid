package com.adalid.plantapp.model.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plant_detail")
data class PlantDetailEntity (
    @PrimaryKey
    val id : Int,
    val nombre : String,
    val tipo : String,
    val descripcion : String,
    val imagen : String
)