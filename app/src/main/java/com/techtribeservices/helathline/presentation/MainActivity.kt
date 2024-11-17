package com.techtribeservices.helathline.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.techtribeservices.helathline.navigation.destinations.Destinations
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            HelathLineTheme {
                NavHost(
                    navController = navController,
                    startDestination = Destinations.Profile("Vihanga Yohan")
                ) {
                    composable<Destinations.Profile> { backStackEntry ->
                        val profile: Destinations.Profile = backStackEntry.toRoute()
                        Page1(
                            profile = profile,
                            navigate = {
                                navController.navigate(route = Destinations.ProfileData(profile.name, age = 20))
                            }
                        )
                    }

                    composable<Destinations.FriendsList> {
                        Page2(
                            navigate = {
                                navController.navigate(route = Destinations.Profile("John Doe"))
                            }
                        )
                    }

                    composable<Destinations.ProfileData> {backStackEntry ->
                        val profile = backStackEntry.toRoute<Destinations.ProfileData>()
                        Page3(
                            profileData = profile,
                            navigate = {
                                navController.navigate(route = Destinations.FriendsList)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Page1(
    profile: Destinations.Profile,
    navigate: () -> Unit,
) {
    Scaffold { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Text(text = "Name: ${profile.name}",
            modifier = modifier
                .clickable {
                    navigate()
                })
    }
}

@Composable
fun Page2(navigate: () -> Unit) {
    Scaffold { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Text(text = "Friends List",
            modifier = modifier
                .clickable {
                    navigate()
                })
    }
}

@Composable
fun Page3(
    profileData: Destinations.ProfileData,
    navigate:() -> Unit) {
    Scaffold { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Text(text = "Profile details: ${profileData.name} - ${profileData.age}",
            modifier = modifier
                .clickable {
                    navigate()
                })
    }
}


@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    HelathLineTheme {

    }
}
