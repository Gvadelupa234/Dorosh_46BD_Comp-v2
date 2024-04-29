package com.example.fruitapp.presentation.fruitListFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fruitapp.data.remote.FruitApiInterface
import kotlinx.coroutines.launch

class FruitViewModel(private val apiInterface: FruitApiInterface) : ViewModel() {
    val fruitLd = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getAllFruits()
    }

    fun getAllFruits() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val fruits = apiInterface.getAllFruits()
            fruitLd.postValue(fruits.toString())
            isLoading.postValue(false)
        }
    }
}