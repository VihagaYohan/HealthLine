package com.techtribeservices.helathline.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.techtribeservices.helathline.presentation.pages.Authentication.ForgotPasswordPage
import com.techtribeservices.helathline.presentation.pages.Authentication.LoginPage
import com.techtribeservices.helathline.presentation.pages.Authentication.RegisterPage

fun NavGraphBuilder.AuthNavGraph(
    navHostController: NavHostController
) {
     navigation(
         route = Graph.AUTHENTICATION,
         startDestination = AuthScreen.login.route
     ) {
        composable(route = AuthScreen.login.route) {
            LoginPage(navController = navHostController)
        }

         composable(route = AuthScreen.register.route) {
             RegisterPage(navController = navHostController)
         }

         composable(route = AuthScreen.forgotPassword.route) {
             ForgotPasswordPage(navController = navHostController )
         }
     }
}

sealed class AuthScreen(val route:String) {
    object login: AuthScreen("Login")
    object register: AuthScreen("Register")
    object forgotPassword: AuthScreen("ForgotPassword")
}