package com.techtribeservices.helathline.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import com.techtribeservices.helathline.utils.Constants

@Composable
fun Carousel() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(Constants.PADDING_MEDIUM))
            .background(
                MaterialTheme.colorScheme.primary
            )
    ) {
        Column(
            modifier = Modifier
                .padding(Constants.PADDING_EXTRA_LARGE)
        ) {
            Text(text = "Looking for \ndesired doctor ?",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = Color.White)

            Spacer(modifier = Modifier
                .height(10.dp))

            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(Constants.PADDING_MEDIUM)
            ) {
                Text(text = "Search For",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CarouselPreview() {
    HelathLineTheme {
        Carousel()
    }
}