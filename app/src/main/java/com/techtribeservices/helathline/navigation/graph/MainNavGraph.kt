package com.techtribeservices.helathline.navigation.graph

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.presentation.pages.Authentication.RegisterPage
import com.techtribeservices.helathline.presentation.pages.Home.HomePage
import com.techtribeservices.helathline.presentation.pages.MainPage
import com.techtribeservices.helathline.presentation.pages.Messages.MessagesPage
import com.techtribeservices.helathline.presentation.pages.Onboarding.OnboardingPage
import com.techtribeservices.helathline.presentation.pages.Settings.SettingsPage
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.techtribeservices.helathline.presentation.pages.BottomBarPage

@Composable
fun MainNavGraph(
    rootNavHostController: NavHostController,
    navHostController: NavHostController
) {
    var currentDestination by rememberSaveable {
        mutableStateOf(AppDestinations.Home)
    }

    val navigationSuiteItemColors = NavigationSuiteDefaults.itemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.primary,
            selectedTextColor = MaterialTheme.colorScheme.primary,
            indicatorColor = MaterialTheme.colorScheme.primaryContainer,
            unselectedIconColor = if (isSystemInDarkTheme()) Color.White.copy(alpha = 0.8f) else Color.Gray.copy(
                alpha = 0.7f
            )
        )
    )

    NavHost(
        navController = navHostController,
        route = Graph.MAIN,
        startDestination = MainScreen.main.route
    ) {
         composable(route = MainScreen.main.route) {
             BottomBarPage()
//             HomePage(
//                 rootNavHostController
//             )


//                NavigationSuiteScaffold(
//                    containerColor = MaterialTheme.colorScheme.background,
//                    navigationSuiteColors = NavigationSuiteDefaults.colors(
//                        navigationBarContainerColor = MaterialTheme.colorScheme.background,
//                        navigationRailContainerColor = MaterialTheme.colorScheme.background
//                    ),
//                    navigationSuiteItems = {
//                        AppDestinations.entries.forEach { it ->
//                            item(
//                                icon = {
//                                    Icon(
//                                        painter = painterResource(it.icon),
//                                        contentDescription = stringResource(it.label)
//                                    )
//                                },
//                                label = {
//                                    Text(
//                                        stringResource(it.label),
//                                        style = MaterialTheme.typography.labelMedium.copy(
//                                            fontWeight = FontWeight.Normal
//                                        )
//                                    )
//                                },
//                                selected = it == currentDestination,
//                                onClick = { currentDestination = it },
//                                alwaysShowLabel = false,
//                                colors = navigationSuiteItemColors
//                            )
//                        }
//                    }
//                ) {
//                    // navigation handles here
//                    when (currentDestination) {
//                        AppDestinations.Home -> HomePage()
//                        AppDestinations.Appointment -> RegisterPage()
//                        AppDestinations.Messages -> MessagesPage()
//                        AppDestinations.Settings -> SettingsPage()
//                    }
//                }
         }


    }
}

enum class AppDestinations(
    @StringRes val label: Int,
    @DrawableRes val icon: Int,
    @StringRes val contentDescription: Int
) {
    Home(R.string.home, R.drawable.home, R.string.home),
    Appointment(R.string.appointment, R.drawable.calendar, R.string.appointment),
    Messages(R.string.messages, R.drawable.message, R.string.messages),
    Settings(R.string.settings, R.drawable.settings, R.string.settings)
}

sealed class MainScreen(val route:String) {
    object main: MainScreen("Main")

}