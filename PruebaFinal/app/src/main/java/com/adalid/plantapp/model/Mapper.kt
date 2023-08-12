package com.adalid.plantapp.model

import com.adalid.plantapp.model.local.entities.*
import com.adalid.plantapp.model.remote.fromNet.*

fun fromInternetPlantEntity(plantList : List<Plant>) : List<PlantEntity>{
    return plantList.map {
        PlantEntity(
            id = it.id,
            nombre = it.nombre,
            tipo = it.tipo,
            descripcion = it.descripcion,
            imagen = it.imagen
        )
    }
}

fun fromInternetPantDetailEntity(plant : PlantDetail) : PlantDetailEntity{
    return PlantDetailEntity(
        id = plant.id,
        nombre = plant.nombre,
        tipo = plant.tipo,
        descripcion = plant.descripcion,
        imagen = plant.imagen
    )
}