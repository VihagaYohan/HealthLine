package com.techtribeservices.helathline.presentation.pages.DoctorDetails.tabs

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techtribeservices.helathline.R
import com.techtribeservices.helathline.ui.theme.HelathLineTheme
import com.techtribeservices.helathline.data.model.mockData.patientReviews
import com.techtribeservices.helathline.utils.Constants

@Composable
fun ReviewTab() {
   patientReviews.forEach { item ->
       Column(
           modifier = Modifier
               .fillMaxWidth()
               .background(MaterialTheme.colorScheme.surface)
       ) {
           val(patientName, rating, review, reviewDate) = item
           TitleSection(patientName, reviewDate, rating)
           Text(text = review,
               style = MaterialTheme.typography.bodyMedium,
               modifier = Modifier
                   .padding(Constants.PADDING_MEDIUM))
       }
   }
}

@Composable
fun TitleSection(name:String,
           date: String,
           rating: Float) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.PADDING_MEDIUM),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                text = date,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Constants.PADDING_SMALL)
        ) {
            Image(
                painter = painterResource(R.drawable.star),
                contentDescription = stringResource(R.string.rating)
            )
            Text(
                text = rating.toString(),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewTabPreview() {
    HelathLineTheme {
        ReviewTab()
    }
}