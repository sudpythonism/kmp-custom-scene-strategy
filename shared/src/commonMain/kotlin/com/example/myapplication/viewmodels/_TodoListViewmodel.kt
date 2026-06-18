//package com.example.myapplication.viewmodels
//
//import androidx.compose.runtime.collectAsState
//import androidx.lifecycle.ViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//
//
//
//class TodoListViewmodel : ViewModel() {
//
//
//    private val _todos = MutableStateFlow(
//        (1..10).map { "todo $it" }
//    )
//
//    val todo = _todos.asStateFlow()
//
//
//
//}