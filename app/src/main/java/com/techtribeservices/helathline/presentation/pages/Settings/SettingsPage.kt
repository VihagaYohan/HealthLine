package com.techtribeservices.helathline.presentation.pages.Settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun SettingsPage() {
    Scaffold { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(
                text = "Settings page"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPagePreview() {
    HelathLineTheme {
        SettingsPage()
    }
}