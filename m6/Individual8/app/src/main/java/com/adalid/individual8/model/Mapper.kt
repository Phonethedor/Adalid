package com.adalid.individual8.model

import com.adalid.individual8.model.local.entities.BreedEntity
import com.adalid.individual8.model.local.entities.ImagesEntity
import com.adalid.individual8.model.remote.fromInternet.Breed
import com.adalid.individual8.model.remote.fromInternet.Images


fun fromInternettoBreedEntity(breed: Breed): List<BreedEntity>{

    val breedNames= breed.message.keys
    return breedNames.map {
        breedNames->
        BreedEntity(breed= breedNames)
    }
}

fun fromInternetToImagesEntity(images: Images, breed: String): List<ImagesEntity>{

    val imageName= images.message
    return imageName.map {
        imageName->
        ImagesEntity(
            imageUrl = imageName,
            breed= breed
        )
    }
}