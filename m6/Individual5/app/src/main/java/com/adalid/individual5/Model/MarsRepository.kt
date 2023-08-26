package com.adalid.individual5.Model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adalid.individual5.Model.Local.MarsDao
import com.adalid.individual5.Model.Remoto.TerrenoDeMArte
import com.adalid.individual5.Model.Remoto.RetrofitClient

class MarsRepository (private val marsDao: MarsDao) {



    private val retrofitClient = RetrofitClient.getRetrofit()

    val dataFromInternet = MutableLiveData<List<TerrenoDeMArte>>()



    suspend fun fetchDataFromInternetCoroutines() {
        try {
            val response = retrofitClient.fetchMarsDataCoroutines()
            when (response.code()) {
                in 200..299 -> response?.body().let {
                    if (it != null) {
                        marsDao.insertarTodosLosTerrenos(it)
                    }
                }

                in 300..301 -> Log.d("REPO", "${response.code()} --- ${response.errorBody()}")
                else -> Log.d("REPO", "${response.code()} --- ${response.errorBody().toString()}")
            }
        } catch (t: Throwable) {
            Log.e("REPO", "${t.message}")
        }
    }

    fun  getTerrainByid(id:String) : LiveData<TerrenoDeMArte> {
        return getTerrainByid(id)
    }

    val listaTodosLosTerrenos: LiveData<List<TerrenoDeMArte>> =marsDao.obtenerTodosLosTerrenos()

    suspend fun insertarTerreno(mars: TerrenoDeMArte) {
        marsDao.insertarTerreno(mars)
    }

    suspend fun updateTerrain(mars: TerrenoDeMArte) {
        marsDao.updateTerrain(mars)
    }

    suspend fun deleteAll() {
        marsDao.deleteAll()
    }

    fun getTerrain(id:Int):LiveData<TerrenoDeMArte>{
        return  marsDao.getMarsId(id)
    }}


