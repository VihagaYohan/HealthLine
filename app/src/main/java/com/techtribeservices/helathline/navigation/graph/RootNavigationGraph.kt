package com.techtribeservices.helathline.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.presentation.pages.MainPage

@Composable
fun RootNavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Graph.AUTHENTICATION,
        route = Graph.ROOT
    ) {
        AuthNavGraph(navController)
        composable(route = Graph.MAIN) {
            MainPage(navController)
        }
//        composable(route = Graph.MAIN) {
//           // MainNavGraph(navController)
//            MainPage()
//        }
    }

}