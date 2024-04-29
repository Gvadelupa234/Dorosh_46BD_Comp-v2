package com.example.fruitapp.data.repository

import com.example.fruitapp.data.remote.ApiFactory
import com.example.fruitapp.data.remote.model.FruitApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FruitRepository {

    private val api = ApiFactory.fruitApi

    suspend fun getAllFruits(): List<FruitApiModel> {
        return withContext(Dispatchers.IO) {
            api.getAllFruits()
        }
    }
}