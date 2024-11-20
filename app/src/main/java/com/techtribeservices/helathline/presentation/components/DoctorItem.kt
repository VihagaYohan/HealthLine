package com.techtribeservices.helathline.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.techtribeservices.helathline.data.model.Doctor

@Composable
fun DoctorItem(data:Doctor) {
    Row {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.profileImage)
                .crossfade(true)
                .build(),
            contentDescription = "${data.fullName()}"
        )
    }
}