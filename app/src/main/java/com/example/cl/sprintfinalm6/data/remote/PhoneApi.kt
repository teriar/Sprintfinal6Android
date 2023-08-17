package com.example.cl.sprintfinalm6.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneApi {
    @GET("products")
    suspend fun getData(): Response<Phones>

    @GET("details/{id}")
    suspend fun  getImages(@Path("id") id:String): Response<DetailPhone>
}