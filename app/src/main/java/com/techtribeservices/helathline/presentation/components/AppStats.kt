package com.techtribeservices.helathline.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import com.techtribeservices.helathline.utils.Constants

@Composable
fun AppStats() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Constants.PADDING_MEDIUM))
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.05f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Constants.PADDING_MEDIUM / 2),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppStatItem(title = "2K", subTitle = "Patients")
            AppStatItem(title = "1K", subTitle = "Reviews")
            AppStatItem(title = "5+", subTitle = "Years exp")
        }
    }
}

@Composable
fun AppStatItem(title: String, subTitle: String) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        AppSpacer(isVertical = true, size = Constants.PADDING_MEDIUM/2)
        Text(text = subTitle, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun AppStatsPreview() {
    HelathLineTheme {
        AppStats()
    }
}