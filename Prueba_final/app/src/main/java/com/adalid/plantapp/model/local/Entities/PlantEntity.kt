package com.adalid.plantapp.model.local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plant")
data class PlantEntity(
    @PrimaryKey
    val id : Int,
    val name : String,
    val type : String,
    val img : String,
    val desc : String
)