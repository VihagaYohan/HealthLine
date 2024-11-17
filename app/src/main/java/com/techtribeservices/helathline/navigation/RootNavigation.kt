package com.techtribeservices.helathline.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.navigation.destinations.Destinations
import com.techtribeservices.helathline.navigation.graph.MainGraph
import com.techtribeservices.helathline.presentation.pages.Authentication.LoginPage
import com.techtribeservices.helathline.presentation.pages.Authentication.RegisterPage
import com.techtribeservices.helathline.presentation.pages.MainPage
import com.techtribeservices.helathline.presentation.pages.Onboarding.OnboardingPage

@Composable
fun RootNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainGraph.Auth
    ) {
        // sub auth graph
        navigation<MainGraph.Auth>(
            startDestination = Destinations.Onboarding
        ) {
            composable<Destinations.Onboarding>{
                OnboardingPage(
                    navigateToLogin = {
                        navController.navigate(Destinations.Login)
                    }
                )
            }

            composable<Destinations.Login> {
                LoginPage(navController = navController)
            }

            composable<Destinations.Register> {
                RegisterPage(navController = navController)
            }
        }

        // sub app graph
        navigation<MainGraph.App>(
            startDestination = Destinations.MainPage
        ) {
            composable<Destinations.MainPage>{
                MainPage(navController = navController)
            }
        }
    }
}