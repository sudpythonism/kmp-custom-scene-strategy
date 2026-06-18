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
//import kotlinx.serialization.modules.SerializersModule
//import kotlinx.serialization.modules.polymorphic
//
//
//@Composable
//fun AuthNavigation(
//    onLogin :() -> Unit,
//    modifier : Modifier = Modifier
//) {
//
//    val config = SavedStateConfiguration {
//        serializersModule = SerializersModule {
//            polymorphic(NavKey::class) {
//                subclass(Route.Auth.Register::class, Route.Auth.Register.serializer())
//                subclass(Route.Auth.Login::class, Route.Auth.Login.serializer())
//            }
//        }
//    }
//    val authBackstack = rememberNavBackStack(configuration = config,
//
//
//        Route.Auth.Login)
//
//    val sharedViewModel = viewModel{ SharedViewModel() }
//    NavDisplay(backStack = authBackstack,
//        modifier = Modifier,
//        entryProvider = entryProvider {
//            entry<Route.Auth.Login> {
//                LoginScreen(
//                    viewmodel = viewModel { LoginViewModel() },
//                    sharedViewModel = sharedViewModel,
//                    onLogin = onLogin,
//                    onRegister = {
//
//                        authBackstack.add(Route.Auth.Register)
//
//                    }
//                )
//
//            }
//            entry<Route.Auth.Register> {
//
//                RegisterScreen(viewmodel = viewModel { RegisterViewModel()},
//                    sharedViewModel = sharedViewModel)
//            }
//
//        })
//
//
//
//}