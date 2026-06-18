package com.example.myapplication.auth

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class SharedViewModel  : ViewModel(){

    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    fun bump(){
        _counter.value++
    }
}