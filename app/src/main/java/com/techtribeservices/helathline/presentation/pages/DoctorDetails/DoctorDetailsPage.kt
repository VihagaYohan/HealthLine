package com.techtribeservices.helathline.presentation.pages.DoctorDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun DoctorDetailsPage(
    doctorId: String,
    navController: NavController
) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Doctor details ${doctorId}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorDetailsPreview() {
    HelathLineTheme {
        DoctorDetailsPage(doctorId = "1", navController = rememberNavController())
    }
}