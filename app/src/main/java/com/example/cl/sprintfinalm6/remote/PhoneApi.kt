package com.example.cl.sprintfinalm6.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneApi {
    @GET("FakeAPIdata/products/")
    suspend fun getData(): Response<Phone>

    @GET("/FakeAPIdata/details/{id}")
    suspend fun  getImages(@Path("id") id:String): Response<DetailPhone>
}