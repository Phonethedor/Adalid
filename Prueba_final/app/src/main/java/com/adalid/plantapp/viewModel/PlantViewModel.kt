package com.adalid.plantapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adalid.plantapp.model.local.DataBase.PlantDB
import com.adalid.plantapp.model.local.Entities.*
import com.adalid.plantapp.model.PlantRepository
import kotlinx.coroutines.launch

class PlantViewModel(application: Application): AndroidViewModel(application) {
    private val repo : PlantRepository
    private val plantDetailLiveData = MutableLiveData<PlantDetailEntity>()
    private var idSelected : String = "-1"

    init {
        val plantDAO = PlantDB.getDataBase(application).getPlantDAO()
        repo = PlantRepository(plantDAO)

        viewModelScope.launch {
            repo.fetchPlant()
        }
    }

    fun getPlantList() : LiveData<List<PlantEntity>> = repo.plantListLiveData

    fun getPlantDetail(): LiveData<PlantDetailEntity> = plantDetailLiveData

    fun getPlantDetailByIdFromInternet(id : String) = viewModelScope.launch {
        val plantDetail = repo.fetchPlantDetail(id)
        plantDetail?.let {
            plantDetailLiveData.postValue(it)
        }
    }
}