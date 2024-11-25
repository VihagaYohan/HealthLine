package com.techtribeservices.helathline.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun AppImage(
    imageUrl: String,
    contentDescription: String,
    contentScale: ContentScale,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
            .width(400.dp)
            .height(500.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AppImagePreview() {
    HelathLineTheme {
        AppImage(
            imageUrl = "",
            contentDescription = stringResource(id = R.string.doctor_profile_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
        )
    }
}