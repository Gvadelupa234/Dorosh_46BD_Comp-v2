package com.example.fruitapp.data.remote

import com.example.fruitapp.data.remote.model.FruitApiModel
import retrofit2.Response
import retrofit2.http.GET

interface FruitApiInterface {
    @GET("/api/fruit/all")
    suspend fun getAllFruits(): List<FruitApiModel>
}