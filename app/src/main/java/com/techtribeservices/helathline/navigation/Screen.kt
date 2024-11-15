package com.techtribeservices.helathline.navigation

sealed class Screen(val route: String) {
    object OnboardingScreen : Screen("onboardingScreen")
    object LoginScreen : Screen("loginScreen")
    object RegisterScreen: Screen("registerScreen")
    object ForgotPasswordScreen: Screen("forgotPasswordScreen")
}