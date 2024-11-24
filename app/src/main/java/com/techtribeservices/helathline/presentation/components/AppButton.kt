package com.techtribeservices.helathline.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import com.techtribeservices.helathline.utils.Constants

@Composable
fun AppButton(title: String, onClick: () -> Unit = {}, isPrimary: Boolean = true) {
    Button(
        onClick = {onClick()},
        shape = RoundedCornerShape(Constants.PADDING_SMALL),
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    ) {
       Text(
           text = title,
           style = MaterialTheme.typography.bodyLarge
       )
    }
}

@Preview(showBackground = true)
@Composable
fun AppButtonPreview() {
    HelathLineTheme {
        AppButton(
            title = "App Button",
            onClick = {},
            isPrimary = true
        )
    }
}