package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val countDownFlow= flow<Int> {
        val startingValue=10
        var currentValue=startingValue
        emit(currentValue)
        while (currentValue>0){
                delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }
    init {
        collectFlow()
    }
    private fun collectFlow(){
        viewModelScope.launch {
            countDownFlow.collect { time->
                delay(1500L)
                println("The current time is $time");
            }
        }
    }
}