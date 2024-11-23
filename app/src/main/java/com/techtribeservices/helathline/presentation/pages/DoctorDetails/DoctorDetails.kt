package com.techtribeservices.helathline.presentation.pages.DoctorDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun DoctorDetails(doctorId: String, navController: NavController) {

}

@Preview(showBackground = true)
@Composable
fun DoctorDetailsPreview() {
    HelathLineTheme {
        DoctorDetails(doctorId="1", navController = rememberNavController())
    }
}