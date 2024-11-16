package com.techtribeservices.helathline.presentation.pages

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.techtribeservices.helathline.navigation.graph.AppDestinations
import com.techtribeservices.helathline.presentation.pages.Messages.MessagesPage
import com.techtribeservices.helathline.presentation.pages.Settings.SettingsPage

@Composable
fun BottomBarPage() {
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
    NavigationSuiteScaffold(
        containerColor = MaterialTheme.colorScheme.background,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContainerColor = MaterialTheme.colorScheme.background,
            navigationRailContainerColor = MaterialTheme.colorScheme.background
        ),
        navigationSuiteItems = {
            AppDestinations.entries.forEach { it ->
                item(
                    icon = {
                        Icon(
                            painter = painterResource(it.icon),
                            contentDescription = stringResource(it.label)
                        )
                    },
                    label = {
                        Text(
                            stringResource(it.label),
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Normal
                            )
                        )
                    },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it },
                    alwaysShowLabel = false,
                    colors = navigationSuiteItemColors
                )
            }
        }
    ) {
        // navigation handles here
        when (currentDestination) {
//                        AppDestinations.Home -> HomePage()
//                        AppDestinations.Appointment -> RegisterPage()
            AppDestinations.Messages -> MessagesPage()
            AppDestinations.Settings -> SettingsPage()
            AppDestinations.Home -> TODO()
            AppDestinations.Appointment -> TODO()
        }
    }
}