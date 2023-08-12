package com.adalid.plantapp.model

import com.adalid.plantapp.model.local.Entities.*
import com.adalid.plantapp.model.remote.fromNet.*

fun fromInternetPlantEntity(plantList : List<Plant>) : List<PlantEntity>{

    return plantList.map {
        PlantEntity(
            id = it.id,
            name = it.name,
            type = it.type,
            img = it.img,
            desc = it.desc
        )
    }
}

fun fromInternetPantDetailEntity(plant : PlantDetail) : PlantDetailEntity{

    return PlantDetailEntity(
        id = plant.id,
        name = plant.name,
        type = plant.type,
        img = plant.img,
        desc = plant.desc
    )
}