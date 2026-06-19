package com.example.myapplication.navigations

import androidx.navigation3.runtime.NavKey

class Navigator(val state: NavigationState) {

    fun navigate(route: NavKey){

         if(route in state.backStack.keys){
             state.topLevelRoute = route
         }else{

             val currentStack = state.backStack[state.topLevelRoute]

             val lastRoute = currentStack?.lastOrNull()

             if ( lastRoute!= null && route::class == lastRoute::class){

                currentStack.removeLastOrNull()

             }


             currentStack?.add(route)
         }

    }


    fun goBack(){
        val currentStack = state.backStack[state.topLevelRoute] ?: error("'Backstack for ${state.topLevelRoute} not found")

        val currentRoute = currentStack.last()


        if (currentRoute == state.topLevelRoute){
            state.topLevelRoute = state.startRoute
        }else{
            currentStack.removeLastOrNull()
        }
    }



}