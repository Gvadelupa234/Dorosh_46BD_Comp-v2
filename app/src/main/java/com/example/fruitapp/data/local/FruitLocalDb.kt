package com.example.fruitapp.data.local

import com.example.fruitapp.data.local.model.FruitEntity

class FruitLocalDb{

    fun getFruitList():List<FruitEntity>{
    return listOf(
        FruitEntity("Banana", 1, "Musaceae", "Zingiberales", "Musa", null),
        FruitEntity("Apple", 6,	"Rosaceae", 	"Rosales", "Malus", null),
        FruitEntity("Cherry", 9,	"Rosaceae", 	"Rosales", "Prunus", null),
        FruitEntity("Pineapple", 10,	"Bromeliaceae", 	"Poales", "Ananas", null),
        FruitEntity("Peach", 86,	"Rosaceae", 	"Rosales", "Prunus", null)

    )

    }

}
