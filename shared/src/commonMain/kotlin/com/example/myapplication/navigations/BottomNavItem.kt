package com.example.myapplication.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val icon : ImageVector,
    val title : String
)


val TOP_LEVEL_DESTINATION = mapOf(
    Route.TodoList to BottomNavItem(
        icon = Icons.Outlined.Check,
        title = "Todos"
    ),
    Route.TodoFavourite  to BottomNavItem(
        icon = Icons.Outlined.Favorite,
        title = "Favorite"
    ),
    Route.Settings to BottomNavItem(
        icon = Icons.Outlined.Settings,
        title = "Settings"
    )

)

