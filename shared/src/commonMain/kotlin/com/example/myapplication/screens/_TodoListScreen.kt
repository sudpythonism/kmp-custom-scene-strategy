//package com.example.myapplication.screens
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.content.MediaType.Companion.Text
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.myapplication.viewmodels.TodoListViewmodel
//
//
//@Composable
//fun TodoListScreen(
//    viewmodel: TodoListViewmodel = viewModel(),
//    onTodoClick : (String ) ->Unit,
//    modifier : Modifier = Modifier
//) {
//
//
//    val todos by viewmodel.todo.collectAsState()
//
//
//    LazyColumn(modifier = modifier.fillMaxSize(),
//        contentPadding = PaddingValues(16.dp),
//
//        ){
//
//        items(todos){it ->
//
//            Text(it,
//                fontSize = 16.sp,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .clickable{
//                    onTodoClick(it)
//                })
//
//        }
//
//
//
//
//    }
//
//
//}