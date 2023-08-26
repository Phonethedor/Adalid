package com.adalid.individual8.model.remote

import com.adalid.individual8.model.remote.fromInternet.Breed
import com.adalid.individual8.model.remote.fromInternet.Images
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {

    @GET("breeds/list/all")
    suspend fun getBreedsList(): Response<Breed>

    @GET("breed/{breed}/images")
    suspend fun getImagesList(@Path("breed") breed: String): Response<Images>

}