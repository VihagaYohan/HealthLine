package com.techtribeservices.helathline.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// pages
import com.techtribeservices.helathline.presentation.pages.Onboarding.OnboardingPage
import com.techtribeservices.helathline.presentation.pages.Authentication.LoginPage
import com.techtribeservices.helathline.presentation.pages.Authentication.RegisterPage
import com.techtribeservices.helathline.presentation.pages.Authentication.ForgotPasswordPage

@Composable
fun NavigationController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.OnboardingScreen.route
    ) {
        composable(route = Screen.OnboardingScreen.route) {
            OnboardingPage(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {
            LoginPage(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterPage(navController = navController)
        }
        composable(route = Screen.ForgotPasswordScreen.route) {
            ForgotPasswordPage(navController = navController)
        }
    }
}