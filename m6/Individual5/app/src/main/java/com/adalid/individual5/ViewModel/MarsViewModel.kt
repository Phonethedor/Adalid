package com.adalid.individual5.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marstest.Model.Local.MarsDataBase
import com.example.marstest.Model.MarsRepository
import com.example.marstest.Model.Remoto.TerrenoDeMArte
import kotlinx.coroutines.launch

class MarsViewModel (application: Application): AndroidViewModel(application) {




    private val repository: MarsRepository

    val todoMarte: LiveData<List<TerrenoDeMArte>>

    init {


        val MarsDao = MarsDataBase.getDataBase(application).getMarsDao()
        repository = MarsRepository(MarsDao)

        viewModelScope.launch {

            repository.fetchDataFromInternetCoroutines()
        }

        todoMarte = repository.listaTodosLosTerrenos


    }


    private var selectedMarsTerrains: MutableLiveData<TerrenoDeMArte> = MutableLiveData()

    fun selected(mars: TerrenoDeMArte) {
        selectedMarsTerrains.value = mars
    }

    fun selectedItem(): LiveData<TerrenoDeMArte> = selectedMarsTerrains


    fun insertarTerreno(mars: TerrenoDeMArte) = viewModelScope.launch {

        repository.insertarTerreno(mars)
    }


    fun updateTerrain(mars: TerrenoDeMArte) = viewModelScope.launch {
        repository.updateTerrain(mars)
    }

    fun getTaskById(id:Int): LiveData<TerrenoDeMArte>{
        return  repository.getTerrain(id)
    }
}