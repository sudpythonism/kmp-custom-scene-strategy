//package com.example.myapplication.screens
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.content.MediaType.Companion.Text
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.myapplication.viewmodels.TodoDetailViewmodel
//import com.example.myapplication.viewmodels.TodoListViewmodel
//
//
//@Composable
//fun TodoDetailScreen(
//    todo: String,
//    viewmodel: TodoDetailViewmodel = viewModel{
//        TodoDetailViewmodel(todo)
//    },
//    modifier : Modifier = Modifier
//) {
//
//
//    Box(modifier = modifier.fillMaxSize(),
//       contentAlignment = Alignment.Center
//    ){
//        Text(todo)
//    }
//
//}