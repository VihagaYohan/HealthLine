package com.techtribeservices.helathline.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.techtribeservices.helathline.navigation.RootNavigation
import com.techtribeservices.helathline.navigation.destinations.Destinations
import com.techtribeservices.helathline.navigation.graph.MainGraph
import com.techtribeservices.helathline.presentation.pages.MainPage
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelathLineTheme {
                RootNavigation()
//                MainPage(navController = rememberNavController())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    HelathLineTheme {
        RootNavigation()
    }
}