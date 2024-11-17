package com.techtribeservices.helathline.presentation.pages

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techtribeservices.helathline.navigation.BottomBarItems
import com.techtribeservices.helathline.presentation.pages.Appointment.AppointmentPage
import com.techtribeservices.helathline.presentation.pages.Home.HomePage
import com.techtribeservices.helathline.presentation.pages.Messages.MessagesPage
import com.techtribeservices.helathline.presentation.pages.Settings.SettingsPage

@Composable
fun MainPage(
    navController: NavController
) {
    var currentDestination by rememberSaveable{ mutableStateOf(BottomBarItems.Home) }
    /*
    * bottom bar material color palette
    * container - surface
    * icon - on secondary container
    * label - on surface
    * indicator - secondary container
    * */

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

    val navigationSuiteColors = NavigationSuiteDefaults.colors(
        navigationBarContainerColor = MaterialTheme.colorScheme.surface,
        navigationRailContainerColor = MaterialTheme.colorScheme.surface,
        navigationDrawerContainerColor = MaterialTheme.colorScheme.surfaceContainer,
    )

    Scaffold(
        bottomBar = {

    }) {innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        NavigationSuiteScaffold(
            navigationSuiteColors = navigationSuiteColors,
            navigationSuiteItems = {
                BottomBarItems.entries.forEach {
                    item(
                        icon = {
                            Icon(
                                painter = painterResource(id = it.icon),
                                contentDescription = stringResource(id = it.label),
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        },
                        label =  {
                            Text(text = stringResource(id = it.label),
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Normal,
                                    color = MaterialTheme.colorScheme.onSurface
                                ))
                        },
                        selected = it === currentDestination,
                        onClick = {
                            currentDestination = it
                        },
                        alwaysShowLabel = false,
                        colors = navigationSuiteItemColors
                    )
                }
            }
        ) {
            when(currentDestination) {
                BottomBarItems.Home -> HomePage(navController = navController)
                BottomBarItems.Appointment -> AppointmentPage()
                BottomBarItems.Messages -> MessagesPage()
                BottomBarItems.Profile -> SettingsPage()
            }
        }
    }
}


