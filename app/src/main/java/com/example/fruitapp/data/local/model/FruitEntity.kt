package com.example.fruitapp.data.local.model

data class FruitEntity(
    val name: String?,
    val id: Int?,
    val family: String?,
    val order: String?,
    val genus: String?,
    val nutritions: Nutritions?
)

data class Nutritions(
    val calories: Double?,
    val fat: Double?,
    val sugar: Double?,
    val carbohydrates: Double?,
    val protein: Double?
)