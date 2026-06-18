package com.example.myapplication.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSerializable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberDecoratedNavEntries
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.savedstate.compose.serialization.serializers.MutableStateSerializer
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

class NavigationState(
    val startRoute: NavKey,
    topLevelRoute : MutableState<NavKey>,
    val backStack : Map<NavKey, NavBackStack<NavKey>>
) {

    var topLevelRoute by topLevelRoute





    val backstackInUse : List<NavKey>
        get() = if (topLevelRoute == startRoute){
            listOf(startRoute)

        }else{
            listOf(startRoute, topLevelRoute)
        }

}

@Composable
fun rememberNavigationState(
    startRoute : NavKey,
    topLevelRoutes: Set<NavKey>
) : NavigationState{



    // Current selected Route
    val topLevelRoute = rememberSerializable(
        startRoute,
        topLevelRoutes,
        configuration = serializerConfig,
        serializer = MutableStateSerializer(PolymorphicSerializer(NavKey::class))
    ){
        mutableStateOf(startRoute)
    }

    val backStacks = topLevelRoutes.associateWith { key ->
        rememberNavBackStack(
            configuration = serializerConfig,
            key
        )
    }


    return remember(startRoute, topLevelRoutes){
        NavigationState(startRoute = startRoute,
            topLevelRoute = topLevelRoute ,
            backStack = backStacks)
    }
}



val serializerConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Route.TodoList::class, Route.TodoList.serializer())
            subclass(Route.TodoDetail::class, Route.TodoDetail.serializer())
            subclass(Route.TodoFavourite::class, Route.TodoFavourite.serializer())
            subclass(Route.Settings::class, Route.Settings.serializer())
        }
    }
}


// why do we even return here a SnapshotStateList instead entryProvider?
@Composable
fun NavigationState.toEntries(
    entryProvider : (NavKey) -> NavEntry<NavKey>
) : SnapshotStateList<NavEntry<NavKey>>{


    // decoratedEntries is a Map<NavKey, List<NavEntry<NavKey>>>
    val decoratedEntries = backStack.mapValues { (_, stack) ->
        val decorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator<NavKey>(),
            rememberViewModelStoreNavEntryDecorator()
        )
        rememberDecoratedNavEntries(
            backStack = stack,
            entryDecorators = decorators,
            entryProvider = entryProvider
        )
    }


    return backstackInUse
        .flatMap { decoratedEntries[it] ?: emptyList() }
        .toMutableStateList()



}