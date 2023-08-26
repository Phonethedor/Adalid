package com.adalid.individual5.Model.Remoto

import retrofit2.Response
import retrofit2.http.GET

interface MarsApi {

    @GET("realestate")
    suspend fun fetchMarsDataCoroutines(): Response<List<TerrenoDeMArte>>

}