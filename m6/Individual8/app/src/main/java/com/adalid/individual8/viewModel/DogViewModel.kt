package com.adalid.individual8.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.adalid.individual8.model.DogRepository
import com.adalid.individual8.model.local.DogDatabase
import com.adalid.individual8.model.local.entities.BreedEntity
import com.adalid.individual8.model.local.entities.ImagesEntity
import kotlinx.coroutines.launch

class DogViewModel(application: Application): AndroidViewModel(application) {

    private val repository: DogRepository

    init {
        val dogdao= DogDatabase.getDatabase(application).getDogDao()
        repository= DogRepository(dogdao)

        viewModelScope.launch {
            repository.fetchBreed()
        }
    }


    fun getBreedList(): LiveData<List<BreedEntity>> = repository.breedsListLiveData

    private var breedSelected: String=""

    fun getImagesByBreedFromInternet(breed: String)= viewModelScope.launch {
        breedSelected=breed
        repository.fetchImage(breed)
    }

    fun getImages(): LiveData<List<ImagesEntity>> =repository.getAllImagesByBreed(breedSelected)

    fun updateFavourite(imagesEntity: ImagesEntity)= viewModelScope.launch {
        repository.updateFavouritesImages(imagesEntity)
    }

    fun deleteAllFavourites(){
        viewModelScope.launch {
            repository.deleteFavouritesImages()
        }
    }
}