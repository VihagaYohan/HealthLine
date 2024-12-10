package com.techtribeservices.helathline.presentation.pages.Appointment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.techtribeservices.helathline.presentation.viewModels.SeedViewModel
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun AppointmentPage(
    modifier: Modifier = Modifier
) {
    val viewModel: SeedViewModel = hiltViewModel()

    Scaffold { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(
                text = "Appointment page"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppointmentPagePreview() {
    HelathLineTheme {
        AppointmentPage()
    }
}