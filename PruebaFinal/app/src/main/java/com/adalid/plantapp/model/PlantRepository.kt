package com.adalid.plantapp.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.adalid.plantapp.model.local.PlantDAO
import com.adalid.plantapp.model.remote.RetrofitClient
import com.adalid.plantapp.model.local.entities.PlantDetailEntity

class PlantRepository(private val plantDAO: PlantDAO) {
    private val retrofitClient = RetrofitClient.retrofitInstance()
    val plantListLiveData = plantDAO.getAllPlants()
    val plantDetailListLiveData = MutableLiveData<PlantDetailEntity>()

    suspend fun fetchPlant(){
        val service= kotlin.runCatching { retrofitClient.fetchPlantList() }
        println("3")
        service.onSuccess {
            when (it.code()){
                in 200..299 ->it.body()?.let {
                    plantDAO.insertAllPlants(fromInternetPlantEntity(it))
                }
                else-> Log.d("Repository error : ","${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error : ", "${it.message}")
            }
        }
    }

    suspend fun fetchPlantDetail(id: String): PlantDetailEntity?{
        val service= kotlin.runCatching { retrofitClient.fetchPlantDetail(id) }
        return service.getOrNull()?.body()?.let {
                plantDetail ->
            val plantDetailEntity= fromInternetPantDetailEntity(plantDetail)
            plantDAO.insertPlantDetail(plantDetailEntity)
            plantDetailEntity
        }
    }
}