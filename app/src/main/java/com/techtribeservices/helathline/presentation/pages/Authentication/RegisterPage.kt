package com.techtribeservices.helathline.presentation.pages.Authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun RegisterPage(
    navController: NavController
) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(
                text = "Register page"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPagePreview() {
    HelathLineTheme {
        RegisterPage(navController = rememberNavController())
    }
}