package com.techtribeservices.helathline.presentation.pages.Authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.navigation.graph.AuthScreen
import com.techtribeservices.helathline.navigation.graph.Graph
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun ForgotPasswordPage(
    navController: NavController
) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(
                text = "Forgot password page"
            )
            Button(onClick = {
                navController.navigate(Graph.MAIN){
                    popUpTo(AuthScreen.login.route){
                        inclusive = true
                    }
                }
            }) {
                Text(text = "Go to main")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPagePreview() {
    HelathLineTheme {
        ForgotPasswordPage(navController = rememberNavController())
    }
}