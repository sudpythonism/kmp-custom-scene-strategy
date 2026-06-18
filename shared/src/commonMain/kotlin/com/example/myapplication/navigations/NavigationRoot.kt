package com.example.myapplication.navigations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.myapplication.scene.ListDetailScene
import com.example.myapplication.scene.ListDetailSceneStrategy
import com.example.myapplication.scene.rememberListDetailSceneStrategy
import com.example.myapplication.screens.TodoDetailScreen
import com.example.myapplication.screens.TodoListScreen
import kotlinx.serialization.builtins.ArraySerializer

import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
//    val backStack = rememberNavBackStack(
//        configuration = SavedStateConfiguration {
//            serializersModule = SerializersModule {
//                polymorphic(NavKey::class) {
//                    subclass(Route.TodoList::class, Route.TodoList.serializer())
//                    subclass(Route.TodoDetail::class, Route.TodoDetail.serializer())
//                }
//            }
//        },
//        Route.TodoList
//    )

    val navigationState = rememberNavigationState(
        startRoute = Route.TodoList,
        topLevelRoutes = TOP_LEVEL_DESTINATION.keys,

    )

    val navigator = remember { Navigator(state = navigationState) }


    Scaffold(
        modifier = Modifier,
        bottomBar = {
        TodoNavigationBar(
            selectedKey = navigationState.topLevelRoute,
            onSelectKey = {
                navigator.navigate(it)
            }
        )

    }) { innerPadding ->






        NavDisplay(
            sceneStrategies = listOf(rememberListDetailSceneStrategy()),
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            onBack = navigator::goBack,

            entries = navigationState.toEntries(

                entryProvider {
                    entry<Route.TodoList>(
                        metadata = ListDetailScene.listPane()
                    ){
                        TodoListScreen(
                            onTodoClick = {

                                navigator.navigate(Route.TodoDetail(it))
                            }
                        )
                    }
                    entry<Route.TodoFavourite>(
                        metadata = ListDetailScene.listPane()
                    ){
                        TodoListScreen(onTodoClick = {
                            navigator.navigate(Route.TodoDetail(it))
                        })

                    }
                    entry<Route.TodoDetail>(
                        metadata = ListDetailScene.detailPane()
                    ){
                        TodoDetailScreen(todo = it.todo)

                    }
                    entry<Route.Settings>{

                        Column(modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("Settings")
                        }

                    }

                }
            )
        )

    }
}