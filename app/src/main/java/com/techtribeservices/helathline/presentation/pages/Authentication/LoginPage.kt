package com.techtribeservices.helathline.presentation.pages.Authentication

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.navigation.destinations.Destinations
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun LoginPage(
    navController: NavController
) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(
                text = "Login page"
            )

            Button(onClick = {
                navController.navigate(Destinations.Register)
            }) {
                Text(text = "Move to Register screen")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    HelathLineTheme {
        LoginPage(navController = rememberNavController())
    }
}