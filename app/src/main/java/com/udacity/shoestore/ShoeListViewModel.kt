package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel :ViewModel(){

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
    get() = _shoeList

    private val _eventAddShoe = MutableLiveData<Boolean>()
    val eventAddShoe:LiveData<Boolean>
    get() = _eventAddShoe
    init {
        _eventAddShoe.value = false
        _shoeList.value= mutableListOf()
    }
    fun addShoe(shoe: Shoe){
        _shoeList.value?.add(shoe)

    }

    fun goAddShoe(){
        _eventAddShoe.value = true
    }


    fun onAddShoeEventComplete(){
        _eventAddShoe.value =false
    }
}