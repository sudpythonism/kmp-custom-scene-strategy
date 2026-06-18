package com.example.myapplication.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun RegisterScreen(
    viewmodel: RegisterViewModel,
    sharedViewModel: SharedViewModel,
    modifier : Modifier = Modifier
) {

    val localCounter by viewmodel.counter.collectAsState()
    val sharedCounter by sharedViewModel.counter.collectAsState()



    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {


        Button(onClick ={
            sharedViewModel.bump()

        }){
            Text("Shared Counter: $sharedCounter")
        }


        Button(onClick ={
            viewmodel.bump()

        }){
            Text("Shared Counter: $localCounter")
        }








    }





}