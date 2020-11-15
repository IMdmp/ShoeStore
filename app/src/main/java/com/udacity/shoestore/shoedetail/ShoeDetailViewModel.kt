package com.udacity.shoestore.shoedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel:ViewModel() {

    private val _eventAddShoe = MutableLiveData<Boolean>()
    val eventAddShoe: LiveData<Boolean>
        get() = _eventAddShoe


    fun addShoe(){
        _eventAddShoe.value = true
    }


    fun onAddShoeEventComplete(){
        _eventAddShoe.value =false
    }
}