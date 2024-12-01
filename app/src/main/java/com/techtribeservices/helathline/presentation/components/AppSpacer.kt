package com.techtribeservices.helathline.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import com.techtribeservices.helathline.utils.Constants

@Composable
fun AppSpacer(isVertical: Boolean = true, size: Dp = Constants.PADDING_MEDIUM) {
    Spacer(
        modifier = if(isVertical) Modifier.height(size) else Modifier.width(size)
    )
}

@Preview(showBackground = true)
@Composable
fun AppSpacerPreview() {
    HelathLineTheme {
        AppSpacer(
            isVertical = true,
            size = Constants.PADDING_MEDIUM
        )
    }
}