package com.udacity.shoestore.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel :ViewModel(){

    private val _eventAddShoe = MutableLiveData<Boolean>()
    val eventAddShoe:LiveData<Boolean>
    get() = _eventAddShoe
    init {
        _eventAddShoe.value = false
    }
    fun addShoe(){
        _eventAddShoe.value = true
    }


    fun onAddShoeEventComplete(){
        _eventAddShoe.value =false
    }
}