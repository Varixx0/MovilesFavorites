package com.listvictortercero.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.listvictortercero.model.Ikea
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IkeaViewModel:ViewModel(){
    private val _furniture= MutableLiveData<List<Ikea>>()
    val furniture: LiveData<List<Ikea>> = _furniture

    private val _selectedFurniture= MutableLiveData<Ikea>()
    val selectedFurniture: LiveData<Ikea> = _selectedFurniture

    private val _isLoading= MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            _isLoading.value=true
            delay(2000)
            _furniture.value=Ikea.getData()
            _isLoading.value =false
        }
    }

    fun deleteFurniture(furniture: Ikea){
        _furniture.value=_furniture.value?.filter { it != furniture }
    }
    fun onFurnitureClicked(furniture: Ikea){
        _selectedFurniture.value=furniture
    }

}