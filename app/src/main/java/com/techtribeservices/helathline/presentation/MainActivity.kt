package com.techtribeservices.helathline.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteColors
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
import androidx.compose.ui.tooling.preview.Preview
import com.techtribeservices.helathline.navigation.AppDestinations
import com.techtribeservices.helathline.presentation.pages.Appointment.AppointmentPage
import com.techtribeservices.helathline.presentation.pages.Home.HomePage
import com.techtribeservices.helathline.presentation.pages.Messages.MessagesPage
import com.techtribeservices.helathline.presentation.pages.Settings.SettingsPage

import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var currentDestination by rememberSaveable {
                mutableStateOf(AppDestinations.Home)
            }

            val navigationSuiteItemColors = NavigationSuiteDefaults.itemColors(
                navigationBarItemColors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    unselectedIconColor = if (isSystemInDarkTheme()) Color.White else Color.Gray
                )
            )

            HelathLineTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    OnboardingPage(modifier = Modifier.padding(innerPadding))
//                }



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
                        AppDestinations.Home -> HomePage()
                        AppDestinations.Appointment -> AppointmentPage()
                        AppDestinations.Messages -> MessagesPage()
                        AppDestinations.Settings -> SettingsPage()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelathLineTheme {
        HomePage()
    }
}