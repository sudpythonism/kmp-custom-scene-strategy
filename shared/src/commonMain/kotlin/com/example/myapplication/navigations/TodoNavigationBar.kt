package com.example.myapplication.navigations

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey


@Composable
fun TodoNavigationBar(
    selectedKey : NavKey,
    onSelectKey : (NavKey) -> Unit,
    modifier : Modifier = Modifier) {

    BottomAppBar(
        modifier = modifier,

    ) {


        TOP_LEVEL_DESTINATION.forEach { (topLevelDestination, data) ->

            NavigationBarItem(
                selected = selectedKey == topLevelDestination,
                onClick = {
                    onSelectKey(topLevelDestination)
                },
                icon = {
                    Icon(imageVector = data.icon, contentDescription = data.title)
                },
                label = {
                    Text(text = data.title)
                }
            )

        }
    }


}