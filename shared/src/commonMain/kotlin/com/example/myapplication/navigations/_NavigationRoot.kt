//package com.example.myapplication.navigations
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
//import androidx.navigation3.runtime.NavKey
//import androidx.navigation3.runtime.entryProvider
//import androidx.navigation3.runtime.rememberNavBackStack
//import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
//import androidx.navigation3.ui.NavDisplay
//import androidx.savedstate.serialization.SavedStateConfiguration
//import com.example.myapplication.screens.TodoDetailScreen
//import com.example.myapplication.screens.TodoListScreen
//import kotlinx.serialization.modules.SerializersModule
//import kotlinx.serialization.modules.polymorphic
////import kotlinx.serialization.modules.subclassesOfSealed
//
//@Composable
//fun NavigationRoot(
//    modifier : Modifier
//) {
//
//
//    val config = SavedStateConfiguration {
//        serializersModule = SerializersModule {
//            polymorphic(NavKey::class) {
////                subclass(RouteA::class, RouteA.serializer())
////                subclass(RouteB::class, RouteB.serializer())
////                subclassesOfSealed<Route>()
//                subclass(Route.Todo::class, Route.Todo.serializer())
//                subclass(Route.Auth::class, Route.Auth.serializer())
//            }
//        }
//    }
//    val rootBackstack = rememberNavBackStack(configuration = config,
//
//        Route.Auth)
//
//
//    NavDisplay(backStack = rootBackstack,
//        entryDecorators = listOf(
//            rememberSaveableStateHolderNavEntryDecorator(),
//            rememberViewModelStoreNavEntryDecorator()
//        ),
//        entryProvider = entryProvider {
//
//            entry<Route.Auth> {
//                AuthNavigation(onLogin = {
////                    rootBackstack.remove(Route.Auth)
//                    rootBackstack.add(Route.Todo)
//                })
//            }
//
//            entry<Route.Todo> {
//
//                TodoNavigation()
//
//
//
//            }
////        }
////        entryProvider = {key ->
////            when(key){
////                is Route.TodoList -> {
////
////                    NavEntry(key){
////                        TodoListScreen(
////                            onTodoClick = {
////
////                                backStack.add(Route.TodoItem(todo = it))
////
////
////                            }
////                        )
////                    }
////                }
////                is Route.TodoItem -> {
////                    NavEntry(key){
////                        TodoDetailScreen(todo = key.todo)
////                    }
////                }
////                else -> error("Unknown NavKey $key")
////            }
//        })
//
//
//}