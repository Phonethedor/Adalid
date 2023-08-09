package com.example.sprint.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sprint.Model.Local.Database.PhoneDataBase
import com.example.sprint.Model.Local.Entitties.PhoneDetailEntity
import com.example.sprint.Model.Local.Entitties.PhoneEntity
import com.example.sprint.Model.PhoneRepository
import kotlinx.coroutines.launch

class PhoneViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PhoneRepository
    private val phoneDetailLiveData = MutableLiveData<PhoneDetailEntity>()

    private var idSelected: String = "-1"

    init {
        val PhoneDao = PhoneDataBase.getDataBase(application).getPhoneDao()
        repository = PhoneRepository(PhoneDao)
        viewModelScope.launch {
            repository.fetchPhone()
        }
    }

    fun getPhoneList(): LiveData<List<PhoneEntity>> = repository.phoneListLiveData

    fun getPhoneDetail(): LiveData<PhoneDetailEntity> = phoneDetailLiveData

    fun getPhoneDetailByIdFromInternet(id: String) = viewModelScope.launch {

        val phoneDetail = repository.fetchPhoneDetail(id)
        phoneDetail?.let {
            phoneDetailLiveData.postValue(it)
        }
    }
}