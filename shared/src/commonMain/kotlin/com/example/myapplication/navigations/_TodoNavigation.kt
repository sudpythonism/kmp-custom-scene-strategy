//package com.example.myapplication.navigations
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation3.runtime.NavKey
//import androidx.navigation3.runtime.entryProvider
//import androidx.navigation3.runtime.rememberNavBackStack
//import androidx.navigation3.ui.NavDisplay
//import androidx.savedstate.serialization.SavedStateConfiguration
//import com.example.myapplication.auth.LoginScreen
//import com.example.myapplication.auth.LoginViewModel
//import com.example.myapplication.auth.RegisterScreen
//import com.example.myapplication.auth.RegisterViewModel
//import com.example.myapplication.auth.SharedViewModel
//import com.example.myapplication.screens.TodoDetailScreen
//import com.example.myapplication.screens.TodoListScreen
//import kotlinx.serialization.modules.SerializersModule
//import kotlinx.serialization.modules.polymorphic
//
//
//@Composable
//fun TodoNavigation(
//    modifier : Modifier = Modifier
//) {
//
//    val config = SavedStateConfiguration {
//        serializersModule = SerializersModule {
//            polymorphic(NavKey::class) {
////                subclass(RouteA::class, RouteA.serializer())
////                subclass(RouteB::class, RouteB.serializer())
////                subclassesOfSealed<Route>()
//                subclass(Route.Todo.TodoList::class, Route.Todo.TodoList.serializer())
//                subclass(Route.Todo.TodoItem::class, Route.Todo.TodoItem.serializer())
//            }
//        }
//    }
//    val todoBackstack = rememberNavBackStack(configuration = config,
//
//
//        Route.Todo.TodoList)
//
//    val sharedViewModel = viewModel{ SharedViewModel() }
//    NavDisplay(backStack = todoBackstack,
//        modifier = Modifier,
//        entryProvider = entryProvider {
//            entry<Route.Todo.TodoList> {
//
//                TodoListScreen(
//                    onTodoClick = {
//                        todoBackstack.add(Route.Todo.TodoItem(todo = it))
//
//                    })
//            }
//            entry<Route.Todo.TodoItem> {
//
//                TodoDetailScreen(todo = it.todo)
//
//                }
//
//        })
//
//
//
//}