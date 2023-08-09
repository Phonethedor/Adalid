package com.example.sprint.Model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sprint.Model.Local.Entitties.PhoneDetailEntity
import com.example.sprint.Model.Local.PhoneDao
import com.example.sprint.Model.Remote.RetrofitClient


class PhoneRepository(private val phoneDao: PhoneDao) {

    private val retrofitClient = RetrofitClient.retrofitInstance()
    val phoneListLiveData = phoneDao.getAllPhones()
    val phoneDetailListLiveData = MutableLiveData<PhoneDetailEntity>()

    suspend fun fetchPhone() {

        val service = kotlin.runCatching { retrofitClient.fetchPhoneList() }

        service.onSuccess {
            when (it.code()) {
                in 200..299 -> it.body()?.let {
                    phoneDao.insertAllPhones(fromInternetPhoneEntity(it))
                }

                else -> Log.d("****Repo****", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("<<<<<<Error>>>>>>>", "${it.message}")
            }
        }
    }

    // Funcion que obtiene los datos de PhoneDetail
    suspend fun fetchPhoneDetail(id: String): PhoneDetailEntity? {
        val service = kotlin.runCatching { retrofitClient.fetchPhoneDetail(id) }
        return service.getOrNull()?.body()?.let { phoneDetail ->
            val phoneDetailEntity = fromInternetPhoneDetailEntity(phoneDetail)
            phoneDao.insertPhoneDetail(phoneDetailEntity)
            phoneDetailEntity
        }
    }
}