package com.techtribeservices.helathline.presentation.pages.DoctorDetails.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun ScheduleTab() {
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "Doctor schedules")
    }
}

@Preview(showBackground = true)
@Composable
fun ScheduledTabPreview() {
    HelathLineTheme {
        ScheduleTab()
    }
}
